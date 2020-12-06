package br.ufpe.cin.banco;

public class OperacaoComValoresNegativosException extends Exception {
    public OperacaoComValoresNegativosException() {
        super("Operação com valores negativos foi tentada em conta.");
    }
}