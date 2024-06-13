package br.com.fiap.fintech.dao;

import java.util.List;

import br.com.fiap.fintech.bean.Visualizacao;
import br.com.fiap.fintech.exception.DBException;

public interface VisualizacaoDAO {
	void atualizar(Visualizacao visualizacao) throws DBException;
	void cadastrar(Visualizacao visualizacao) throws DBException;
	void remover(int codigo) throws DBException;
	Visualizacao buscar(int codigo);
	List<Visualizacao> listar();
}
