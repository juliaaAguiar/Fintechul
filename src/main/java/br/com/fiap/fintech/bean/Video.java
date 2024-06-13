package br.com.fiap.fintech.bean;

public class Video {
	private int codigo;
	private String descricao;
	private String link;
	private int quantidade_visualizacoes;
	private String titulo;

	
	public Video() {}
	
	public Video(String descricao, String link, String titulo) {
		this.descricao = descricao;
		this.link = link;
		this.titulo = titulo;
	}
	
	public Video(int codigo, String descricao, String link, String titulo) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.link = link;
		this.titulo = titulo;
	} 
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getQuantidadeVisualizacoes() {
		return quantidade_visualizacoes;
	}
	public void setQuantidadeVisualizacoes(int quantidade_visualizacoes) {
		this.quantidade_visualizacoes = quantidade_visualizacoes;
	}
}
