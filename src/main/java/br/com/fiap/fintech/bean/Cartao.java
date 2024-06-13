package br.com.fiap.fintech.bean;

public class Cartao {
	private int codigo;
	private Conta conta;
	private long numero;
	private String status;
	private String tipo;
	private int virtual;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public long getNumero() {
		return numero;
	}
	public void setNumero(long numero) {
		this.numero = numero;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Conta getConta() {
		return conta;
	}
	public void setConta(Conta conta) {
		this.conta = conta;
	}
	public int getIsVirtual() {
		return virtual;
	}
	public void setIsVirtual(int virtual) {
		this.virtual = virtual;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public Cartao () {}
	
	public Cartao (int codigo, long numero, Conta conta) {
		this.codigo = codigo;
		this.numero = numero;
		this.conta = conta;
	}
	
	public Cartao (int codigo, long numero) {
		this.codigo = codigo;
		this.numero = numero;
	}
	
	public Cartao (int codigo, long numero, String tipo, int virtual) {
		this.codigo = codigo;
		this.numero = numero;
		this.tipo = tipo;
		this.virtual = virtual;
	}
	
	public Cartao (long numero, String status, String tipo, int virtual, Conta conta) {
		this.conta = conta;
		this.numero = numero;
		this.status = status;
		this.tipo = tipo;
		this.virtual = virtual;
	}
	
	public Cartao (long numero, String status, int virtual, Conta conta) {
		this.conta = conta;
		this.numero = numero;
		this.status = status;
		this.virtual = virtual;
	}	
	
	public Cartao(int codigo, int codigo_conta, long numero, String tipo_cartao, int virtual) {
		this.codigo = codigo;
		this.conta.setCodigo(codigo_conta);
		this.numero = numero;
		this.tipo = tipo_cartao;
		this.virtual = virtual;
	}
}
