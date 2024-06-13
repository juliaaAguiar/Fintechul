package br.com.fiap.fintech.bean;

public class Pessoa {
	// private int codigo;
	private double cpf;
	private String nome;
	private String status;
	
	public Pessoa() {}
	
	public Pessoa(String nome, double cpf, String status) {
		//this.codigo = codigo;
		this.nome = nome;
		this.cpf = cpf;
		this.status = status;
	}
	
//	public int getCodigo() {
//		return codigo;
//	}
//	public void setCodigo(int codigo) {
//		this.codigo = codigo;
//	}
	public double getCpf() {
		return cpf;
	}
	public void setCpf(double cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
