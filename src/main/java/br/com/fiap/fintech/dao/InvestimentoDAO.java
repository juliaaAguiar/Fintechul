package br.com.fiap.fintech.dao;

import java.util.List;

import br.com.fiap.fintech.bean.Investimento;
import br.com.fiap.fintech.exception.DBException;

public interface InvestimentoDAO {
	void atualizar(Investimento investimento) throws DBException;
	void cadastrar(Investimento investimento) throws DBException;
	void remover(Investimento investimento) throws DBException;
	Investimento buscar(int codigo_ativo, int codigo_carteira);
	List<Investimento> listar();
}
