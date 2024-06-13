package br.com.fiap.fintech.bean;

import java.util.Collection;

public class CarteiraInvestimento {
	private Collection<Ativo> ativo;
	private int codigo;
	private Conta conta;
	private String nome;
	private int quantidadeAtivos;
	private double totalInvestido;
	private Usuario usuario;
	
	public CarteiraInvestimento() {}
	
	public CarteiraInvestimento(int codigo, String nome, int quantidadeAtivos, double totalInvestido) {
		this.codigo = codigo;
		this.nome = nome;
		this.quantidadeAtivos = quantidadeAtivos;
		this.totalInvestido = totalInvestido;
	}
	
	public CarteiraInvestimento(int codigo, String nome, Conta conta) {
		this.codigo = codigo;
		this.nome = nome;
		this.conta = conta;
	}
	
	public CarteiraInvestimento(String nome, Conta conta) {
		this.nome = nome;
		this.conta = conta;
	}
	
	public Collection<Ativo> getAtivo() {
		return ativo;
	}
	public void setAtivo(Collection<Ativo> ativo) {
		this.ativo = ativo;
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
	public int getQuantidadeAtivos() {
		return quantidadeAtivos;
	}
	public void setQuantidadeAtivos(int quantidadeAtivos) {
		this.quantidadeAtivos = quantidadeAtivos;
	}
	public double getTotalInvestido() {
		return totalInvestido;
	}
	public void setTotalInvestido(double totalInvestido) {
		this.totalInvestido = totalInvestido;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
