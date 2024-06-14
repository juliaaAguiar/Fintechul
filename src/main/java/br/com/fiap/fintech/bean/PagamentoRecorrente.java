package br.com.fiap.fintech.bean;

import java.sql.Date;

public class PagamentoRecorrente {
	private int codigo;
	private Conta conta;
	private int diaCobranca;
	private double valor;
	private String nome;
	private Date data;
	
	public PagamentoRecorrente () {} 
	
	public PagamentoRecorrente (Date data, String nome, double valor, Conta conta) {
		this.conta = conta;
		this.data = data;
		this.nome = nome;
		this.valor = valor;
	} 
	
	public PagamentoRecorrente(int codigo, Date data, String nome, double valor) {
		this.codigo = codigo;
		this.data = data;
		this.nome = nome;
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
	public int getDiaCobranca() {
		return diaCobranca;
	}
	public void setDiaCobranca(int diaCobranca) {
		this.diaCobranca = diaCobranca;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
}
