package br.com.fiap.fintech.teste;

import br.com.fiap.fintech.bean.Ativo;
import br.com.fiap.fintech.bean.CarteiraInvestimento;
import br.com.fiap.fintech.bean.Investimento;
import br.com.fiap.fintech.dao.AtivoDAO;
import br.com.fiap.fintech.dao.CarteiraInvestimentoDAO;
import br.com.fiap.fintech.dao.InvestimentoDAO;
import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.factory.DAOFactory;

public class InvestimentoDAOTeste {
	public static void main(String[] args) {
		AtivoDAO ativodao = DAOFactory.getAtivoDAO();
		CarteiraInvestimentoDAO carteiradao = DAOFactory.getCarteiraInvestimentoDAO();
		InvestimentoDAO investimentodao = DAOFactory.getInvestimentoDAO();
		try {
			CarteiraInvestimento carteira = carteiradao.buscar(1);
			Ativo ativo = ativodao.buscar(1);
			java.util.Date dataUtil = new java.util.Date();
			java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());
			Investimento investimento = new Investimento(ativo, carteira, dataSql, 10);
			investimentodao.cadastrar(investimento);
			System.out.println("Investimento cadastrado! ");
		} catch (DBException e) {
			e.printStackTrace();
		}
	}
}
