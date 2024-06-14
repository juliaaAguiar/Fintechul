package br.com.fiap.fintech.teste;

import br.com.fiap.fintech.bean.CartaoDebito;
import br.com.fiap.fintech.bean.Despesa;
import br.com.fiap.fintech.dao.CartaoDAO;
import br.com.fiap.fintech.dao.DespesaDAO;
import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.factory.DAOFactory;

public class DespesaDAOTeste {
	public static void main(String[] args) {
		DespesaDAO despesadao = DAOFactory.getDespesaDAO();
		CartaoDAO cartaodao = DAOFactory.getCartaoDebitoDAO();
		try {
			CartaoDebito cartao = (CartaoDebito) cartaodao.buscar(10);
			java.util.Date dataUtil = new java.util.Date();
			java.sql.Date data = new java.sql.Date(dataUtil.getTime());
			Despesa despesa = new Despesa(data, 45.00, cartao);
			despesadao.cadastrar(despesa);
			System.out.println("Despesa cadastrada! ");
		} catch (DBException e) {
			e.printStackTrace();
		}
	}
}
