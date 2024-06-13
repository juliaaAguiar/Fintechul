package br.com.fiap.fintech.dao;

import java.util.List;

import br.com.fiap.fintech.bean.Cartao;
import br.com.fiap.fintech.exception.DBException;

public interface CartaoDAO {
	void atualizar(Cartao cartao) throws DBException;
	int cadastrar(Cartao cartao) throws DBException;
	void remover(int codigo) throws DBException;
	Cartao buscar(int codigo);
	List<Cartao> listar();
}
