package br.com.fiap.fintech.dao;

import java.util.List;

import br.com.fiap.fintech.bean.Deposito;
import br.com.fiap.fintech.exception.DBException;

public interface DepositoDAO {
	void atualizar(Deposito deposito) throws DBException;
	void cadastrar(Deposito deposito) throws DBException;
	void remover(int codigo) throws DBException;
	Deposito buscar(int codigo);
	List<Deposito> listar();
}
