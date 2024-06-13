package br.com.fiap.fintech.dao;

import java.util.List;

import br.com.fiap.fintech.bean.Ativo;
import br.com.fiap.fintech.exception.DBException;

public interface AtivoDAO {
	void atualizar(Ativo ativo) throws DBException;
	void cadastrar(Ativo ativo) throws DBException;
	void remover(int codigo) throws DBException;
	Ativo buscar(int codigo);
	List<Ativo> listar();
}
