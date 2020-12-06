package br.ufpe.cin.dados;

import java.util.Vector;
import java.util.stream.Stream;

import br.ufpe.cin.banco.ContaAbstrata;

public class RepositorioContasVector implements RepositorioContas {
    private Vector<ContaAbstrata> contas;

    @Override
    public void inserir(ContaAbstrata conta) {
        contas.add(conta);
    }

    @Override
    public ContaAbstrata procurar(String numero) throws ContaNaoEncontradaException {
        return contas
            .stream()
            .filter(conta -> conta.getNumero() == numero)
            .findFirst()
            .orElseThrow(() -> new ContaNaoEncontradaException());
    }

    @Override
    public void remover(String numero) throws ContaNaoEncontradaException {
        Stream.iterate(0, n -> n + 1)
            .limit(contas.size())
            .filter(n -> contas.get(n).getNumero() == numero)
            .findFirst()
            .map(n -> {
                contas.remove(n);
                return n;
            })
            .orElseThrow(() -> new ContaNaoEncontradaException());
    }

    @Override
    public void atualizar(ContaAbstrata conta) throws ContaNaoEncontradaException {
        remover(conta.getNumero());
        inserir(conta);
    }

    @Override
    public boolean existe(String numero) {
        return contas
            .stream()
            .map(ContaAbstrata::getNumero)
            .anyMatch(numero::equals);
    }
}
