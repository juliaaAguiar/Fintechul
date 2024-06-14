package br.com.fiap.fintech.dao;

import java.util.List;

import br.com.fiap.fintech.bean.Pessoa;
import br.com.fiap.fintech.exception.DBException;

public interface PessoaDAO {
	void atualizar(Pessoa pessoa) throws DBException;
	int cadastrar(Pessoa pessoa) throws DBException;
	void remover(int codigo) throws DBException;
	Pessoa buscar(int codigo);
	List<Pessoa> listar();
}
