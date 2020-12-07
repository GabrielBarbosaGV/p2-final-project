package br.ufpe.cin.banco;

public class PoupancaEsp extends Poupanca {
    public PoupancaEsp(String numero, Double valor) {
        super(numero, valor);
    }

    public PoupancaEsp(String numero) {
        super(numero);
    }

    public void renderJuros(Double taxa) throws OperacaoComValoresNegativosException {
        super.renderJuros(taxa * 0.01);
    }
}