package br.com.fiap.fintech.bean;

public class CartaoDebito extends Cartao {
	private double saldo; 
	
    public CartaoDebito() {
        super();
    } 

    public CartaoDebito(int codigo, int numero, Conta conta) {
        super(codigo, numero, conta);
    }
    
    public CartaoDebito(int codigo, double saldo) {
    	super.setCodigo(codigo);
    	this.saldo = saldo;
    }
    
    public CartaoDebito(int codigo, int numero, Conta conta, double saldo) {
    	super(codigo, numero, conta);
    	this.saldo = saldo;
    }
    
	public CartaoDebito(long numero, String status, int virtual, double saldo, Conta conta) {
		super(numero, status, "debito", virtual, conta);
		this.saldo = saldo;
	}

	public double getSaldo() {
		return this.saldo;
	}
	
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
}
