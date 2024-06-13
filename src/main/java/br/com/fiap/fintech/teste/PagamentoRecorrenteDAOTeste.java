package br.com.fiap.fintech.teste;

import br.com.fiap.fintech.bean.Conta;
import br.com.fiap.fintech.bean.PagamentoRecorrente;
import br.com.fiap.fintech.dao.ContaDAO;
import br.com.fiap.fintech.dao.PagamentoRecorrenteDAO;
import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.factory.DAOFactory;

public class PagamentoRecorrenteDAOTeste {
	public static void main(String[] args) {
		PagamentoRecorrenteDAO pagamentorecorrentedao = DAOFactory.getPagamentoRecorrenteDAO();
		ContaDAO contadao = DAOFactory.getContaDAO();
		try {
			Conta conta = contadao.buscar(1);
			java.util.Date dataUtil = new java.util.Date();
			java.sql.Date data = new java.sql.Date(dataUtil.getTime());
			PagamentoRecorrente pagamentoRecorrente = new PagamentoRecorrente(data, "Internet", 100.00, conta);
			pagamentorecorrentedao.cadastrar(pagamentoRecorrente);
			System.out.println("Pagamento recorrente cadastrado! ");
		} catch (DBException e) {
			e.printStackTrace();
		}
	}
}
