package br.com.fiap.fintech.teste;

import br.com.fiap.fintech.bean.CartaoCredito;
import br.com.fiap.fintech.bean.Conta;
import br.com.fiap.fintech.dao.CartaoDAO;
import br.com.fiap.fintech.dao.ContaDAO;
import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.factory.DAOFactory;

public class CartaoCreditoDAOTeste {
	public static void main(String[] args) {
		ContaDAO contadao = DAOFactory.getContaDAO();
		CartaoDAO cartaocreditodao = DAOFactory.getCartaoCreditoDAO();
		try {
			Conta conta = contadao.buscar(1); 
			CartaoCredito cartaoCredito = new CartaoCredito(5502495678123434l, "ativo", 0, conta, 10, 800.00);
			cartaocreditodao.cadastrar(cartaoCredito);
			System.out.println("Cartao de credito cadastrado! ");
		} catch (DBException e) {
			e.printStackTrace();
		}
	}
}
