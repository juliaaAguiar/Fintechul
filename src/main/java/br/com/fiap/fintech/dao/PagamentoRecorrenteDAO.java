package br.com.fiap.fintech.dao;

import java.util.List;

import br.com.fiap.fintech.bean.PagamentoRecorrente;
import br.com.fiap.fintech.exception.DBException;

public interface PagamentoRecorrenteDAO {
	void atualizar(PagamentoRecorrente pagamentoRecorrente) throws DBException;
	void cadastrar(PagamentoRecorrente pagamentoRecorrente) throws DBException;
	void remover(int codigo) throws DBException;
	PagamentoRecorrente buscar(int codigo);
	List<PagamentoRecorrente> listar();
}
