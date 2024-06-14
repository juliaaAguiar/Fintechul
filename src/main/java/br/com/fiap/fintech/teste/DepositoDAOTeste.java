package br.com.fiap.fintech.teste;

import br.com.fiap.fintech.bean.Conta;
import br.com.fiap.fintech.bean.Deposito;
import br.com.fiap.fintech.dao.ContaDAO;
import br.com.fiap.fintech.dao.DepositoDAO;
import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.factory.DAOFactory;

public class DepositoDAOTeste {
	public static void main(String[] args) {
		DepositoDAO depositodao = DAOFactory.getDepositoDAO();
		ContaDAO contadao = DAOFactory.getContaDAO();
		try {
			Conta conta = contadao.buscar(1);
			java.util.Date dataUtil = new java.util.Date();
			java.sql.Date data = new java.sql.Date(dataUtil.getTime());
			Deposito deposito = new Deposito(data, 45.00, conta);
			depositodao.cadastrar(deposito);
			System.out.println("Deposito cadastrado! ");
		} catch (DBException e) {
			e.printStackTrace();
		}
	}
}
