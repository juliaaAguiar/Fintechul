package br.com.fiap.fintech.bean;

import java.sql.Date;

public class Despesa {
	private Cartao cartao;
	private int codigo;
	private Date data;
	private double valor;
	
	public Despesa() {} 
	
	public Despesa(Date data, double valor) {
		this.data = data;
		this.valor = valor;
	}
	
	public Despesa(Date data, double valor, Cartao cartao) {
		this.data = data;
		this.valor = valor;
		this.cartao = cartao;
	}
	
	public Despesa(int codigo, Date data, double valor) {
		this.codigo = codigo;
		this.data = data;
		this.valor = valor;
	}
	
	public Cartao getCartao() {
		return cartao;
	}
	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Date getData() {
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
