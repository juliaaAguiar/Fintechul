package br.com.fiap.fintech.bean;

import java.sql.Date;

public class Investimento {
	private Ativo ativo;
	private CarteiraInvestimento carteiraInvestimento;
	private int codigo;
	private Date data;
	private int quantidade;
	
	public Investimento () {}
	
	public Investimento (Ativo ativo, CarteiraInvestimento carteiraInvestimento) {
		this.ativo = ativo;
		this.carteiraInvestimento = carteiraInvestimento;
	}
	
	public Investimento (Ativo ativo, CarteiraInvestimento carteiraInvestimento, Date data, int quantidade) {
		this.ativo = ativo;
		this.carteiraInvestimento = carteiraInvestimento;
		this.data = data;
		this.quantidade = quantidade;
	}
	
	public Investimento (Ativo ativo, CarteiraInvestimento carteiraInvestimento, int quantidade) {
		this.ativo = ativo;
		this.carteiraInvestimento = carteiraInvestimento;
		this.quantidade = quantidade;
	}
	
	public Investimento (int codigo_ativo, int codigo_carteira, int quantidade) {
		this.ativo.setCodigo(codigo_ativo);
		this.carteiraInvestimento.setCodigo(codigo_carteira);
		this.quantidade = quantidade;
	}
	
	public Investimento(int codigo, int codigo_ativo, int codigo_carteira, int quantidade) {
		this.codigo = codigo;
		this.ativo.setCodigo(codigo_ativo);
		this.carteiraInvestimento.setCodigo(codigo_carteira);
		this.quantidade = quantidade;
	}

	public CarteiraInvestimento getCarteiraInvestimento() {
		return carteiraInvestimento;
	}
	public void setCarteiraInvestimento(CarteiraInvestimento carteiraInvestimento) {
		this.carteiraInvestimento = carteiraInvestimento;
	}
	public Ativo getAtivo() {
		return ativo;
	}
	public void setAtivo(Ativo ativo) {
		this.ativo = ativo;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
}
