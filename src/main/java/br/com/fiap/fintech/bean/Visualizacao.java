package br.com.fiap.fintech.bean;

import java.sql.Date;

public class Visualizacao {
	private int codigo;
	private Date data;
	private Usuario usuario;
	private Video video;
	
	public Visualizacao() {}
	public Visualizacao(Usuario usuario, Video video, Date data) {
		this.data = data;
		this.usuario = usuario;
		this.video = video;
	}
	
	public Visualizacao(int codigo, int codigo_usuario, int codigo_video, Date data) {
		this.codigo = codigo;
		this.getUsuario().setCodigo(codigo_usuario);
		this.getVideo().setCodigo(codigo_video);
		this.data = data;
	} 
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Video getVideo() {
		return video;
	}
	public void setVideo(Video video) {
		this.video = video;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
}
