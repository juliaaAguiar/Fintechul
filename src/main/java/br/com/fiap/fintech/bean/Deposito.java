package br.com.fiap.fintech.bean;

import java.sql.Date;

public class Deposito {
	private int codigo;
	private Conta conta;
	private Date data;
	private double valor;
	
	public Deposito() {}
	
	public Deposito (Date data, double valor, Conta conta) {
		this.conta = conta;
		this.data = data;
		this.valor = valor;
	}
	
	public Deposito(int codigo, Date data, double valor) {
		this.codigo = codigo;
		this.data = data;
		this.valor = valor;
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Conta getConta() {
		return conta;
	}
	public void setConta(Conta conta) {
		this.conta = conta;
	}
	public java.sql.Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
}
