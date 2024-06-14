package br.com.fiap.fintech.bean;

public class CartaoCredito extends Cartao {
	private int diaVencimentoFatura;
	private double limite;
		
	public CartaoCredito() { super(); }
	
	public CartaoCredito(int codigo, int numero, Conta conta, int diaVencimentoFatura, double limite) {
		super(codigo, numero, conta);
		this.diaVencimentoFatura = diaVencimentoFatura;
		this.limite = limite;
	}
	
	public CartaoCredito(long numero, String status, int virtual, Conta conta, int diaVencimentoFatura, double limite) {
		super(numero, status, "credito", virtual, conta);
		this.diaVencimentoFatura = diaVencimentoFatura;
		this.limite = limite;
	}
	
	public CartaoCredito(int codigo, int diaVencimentoFatura, double limite) {
		super.setCodigo(codigo);
		this.diaVencimentoFatura = diaVencimentoFatura;
		this.limite = limite;
	}
	
	public int getDiaVencimentoFatura() {
		return diaVencimentoFatura;
	}
	public void setDiaVencimentoFatura(int diaVencimentoFatura) {
		this.diaVencimentoFatura = diaVencimentoFatura;
	}
	public double getLimite() {
		return limite;
	}
	public void setLimite(double limite) {
		this.limite = limite;
	}
}
