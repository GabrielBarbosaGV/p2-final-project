package br.ufpe.cin.banco;

public class Poupanca extends Conta {
	
	public Poupanca(String numero, double valor) {
		super(numero, valor);
	}
	
	public Poupanca(String numero) {
		this(numero, 0.0);
	}
	
	public void renderJuros(double taxa) {
		double juros = this.getSaldo() * taxa;
		this.creditar(juros);
	}
}
