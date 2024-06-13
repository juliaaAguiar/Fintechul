package br.com.fiap.fintech.dao;

import java.util.List;

import br.com.fiap.fintech.bean.Video;
import br.com.fiap.fintech.exception.DBException;

public interface VideoDAO {
	void atualizar(Video video) throws DBException;
	void cadastrar(Video video) throws DBException;
	void remover(int codigo) throws DBException;
	Video buscar(int codigo);
	List<Video> listar();
}
