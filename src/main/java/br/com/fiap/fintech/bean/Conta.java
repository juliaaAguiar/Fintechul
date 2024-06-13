package br.com.fiap.fintech.bean;

public class Conta {
	private int agencia;
	private String banco;
	private int codigo;
	private int numero;
	private double saldo;
	private String tipo;
	private Usuario usuario;
	
	public Conta() {}

	public Conta(int agencia, int numero, double saldo, String tipo) {
		this.agencia = agencia;
		this.numero = numero;
		this.saldo = saldo;
		this.tipo = tipo;
	}
	
	public Conta(int agencia, int numero, String tipo, Usuario usuario) {
		this.agencia = agencia;
		this.numero = numero;
		this.tipo = tipo;
		this.usuario = usuario;
	}
	
	public Conta(int agencia, int codigo, int numero, double saldo, String tipo) {
		this.agencia = agencia;
		this.codigo = codigo;
		this.numero = numero;
		this.saldo = saldo;
		this.tipo = tipo;
	}
	
	public Conta(int agencia, int numero, double saldo, String tipo, Usuario usuario) {
		this.agencia = agencia;
		this.numero = numero;
		this.saldo = saldo;
		this.tipo = tipo;
		this.usuario = usuario;
	}
	
	public Conta(int agencia, int codigo, int numero, double saldo, String tipo, Usuario usuario) {
		this.agencia = agencia;
		this.codigo = codigo;
		this.numero = numero;
		this.saldo = saldo;
		this.tipo = tipo;
		this.usuario = usuario;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
}
