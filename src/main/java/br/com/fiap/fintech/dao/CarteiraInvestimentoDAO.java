package br.com.fiap.fintech.dao;

import java.util.List;

import br.com.fiap.fintech.bean.CarteiraInvestimento;
import br.com.fiap.fintech.exception.DBException;

public interface CarteiraInvestimentoDAO {
	void atualizar(CarteiraInvestimento carteira) throws DBException;
	void cadastrar(CarteiraInvestimento carteira) throws DBException;
	void remover(int codigo) throws DBException;
	CarteiraInvestimento buscar(int codigo);
	List<CarteiraInvestimento> listar();
}
