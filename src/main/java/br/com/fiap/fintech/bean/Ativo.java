package br.com.fiap.fintech.bean;

public class Ativo {
	private int codigo;
	private String descricao;
	private String nome;
	private String tipo;
	private double valorAtual;
	
	public Ativo () {}
	
	public Ativo (String nome, String tipo_ativo) {
		this.nome = nome;
		this.tipo = tipo_ativo;
	}
	
	public Ativo (String nome, Double valor_atual) {
		this.nome = nome;
		this.valorAtual = valor_atual;
	}
	
	public Ativo (String nome, String tipo_ativo, Double valor_atual) {
		this.nome = nome;
		this.tipo = tipo_ativo;
		this.valorAtual = valor_atual;
	}
	
	public Ativo (String descricao, String nome, String tipo_ativo, Double valor_atual) {
		this.descricao = descricao;
		this.nome = nome;
		this.tipo = tipo_ativo;
		this.valorAtual = valor_atual;
	}
	
	public Ativo (int codigo, String descricao, String nome, String tipo_ativo, Double valor_atual) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.nome = nome;
		this.tipo = tipo_ativo;
		this.valorAtual = valor_atual;
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public double getValorAtual() {
		return valorAtual;
	}
	public void setValorAtual(double valorAtual) {
		this.valorAtual = valorAtual;
	}
}
