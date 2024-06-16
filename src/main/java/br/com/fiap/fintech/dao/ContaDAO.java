package br.com.fiap.fintech.dao;

import java.util.List;

import br.com.fiap.fintech.bean.Conta;
import br.com.fiap.fintech.bean.Extrato;
import br.com.fiap.fintech.bean.Usuario;
import br.com.fiap.fintech.exception.DBException;

public interface ContaDAO {
	void atualizar(Conta conta) throws DBException;
	void cadastrar(Conta conta) throws DBException;
	void remover(int codigo) throws DBException;
	Conta buscar(int codigo);
	List<Conta> listar();
	Extrato extrato(Conta conta, Usuario usuario);
}
