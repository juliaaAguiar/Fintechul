package br.com.fiap.fintech.bean;

public class Usuario extends Pessoa {
	private int codigo;
	private int codigo_pessoa;
	private String email;
	private String perfil;
	private Pessoa pessoa;
	private String senha;
	private String telefone;
	
	public Usuario() {}
	
	public Usuario(int codigo, int codigo_pessoa, String email, String senha, String telefone, String perfil) {
		this.codigo = codigo;
		this.email = email;
		this.senha = senha;
		this.telefone = telefone;
		this.perfil = perfil;
		this.codigo_pessoa = codigo_pessoa;
	}
	
	public Usuario(String email, String senha, String telefone, String perfil) {
		this.email = email;
		this.senha = senha;
		this.perfil = perfil;
		this.telefone = telefone;
	}
	
	public Usuario(String email, String senha, String telefone, String perfil, Pessoa pessoa) {
		this.email = email;
		this.senha = senha;
		this.perfil = perfil;
		this.telefone = telefone;
		this.pessoa = pessoa;
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPerfil() {
		return perfil;
	}
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public int getCodigoPessoa() {
		return codigo_pessoa;
	}

	public void setCodigoPessoa(int codigo_pessoa) {
		this.codigo_pessoa = codigo_pessoa;
	}
}
