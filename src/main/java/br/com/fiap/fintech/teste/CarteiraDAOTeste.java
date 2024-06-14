package br.com.fiap.fintech.teste;

import br.com.fiap.fintech.bean.CarteiraInvestimento;
import br.com.fiap.fintech.bean.Conta;
import br.com.fiap.fintech.dao.CarteiraInvestimentoDAO;
import br.com.fiap.fintech.dao.ContaDAO;
import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.factory.DAOFactory;

public class CarteiraDAOTeste {
	public static void main(String[] args) {
		CarteiraInvestimentoDAO carteiradao = DAOFactory.getCarteiraInvestimentoDAO();
		ContaDAO contadao = DAOFactory.getContaDAO();
		try {
			Conta conta = contadao.buscar(1);
			CarteiraInvestimento carteira = new CarteiraInvestimento("renda fixa", conta);
			carteiradao.cadastrar(carteira);
			System.out.println("carteira cadastrada! ");
		} catch (DBException e) {
			e.printStackTrace();
		}
	}
}
