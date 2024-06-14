package br.com.fiap.fintech.teste;

import br.com.fiap.fintech.bean.CartaoDebito;
import br.com.fiap.fintech.bean.Conta;
import br.com.fiap.fintech.dao.CartaoDAO;
import br.com.fiap.fintech.dao.ContaDAO;
import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.factory.DAOFactory;

public class CartaoDebitoDAOTeste {
	public static void main(String[] args) {
		ContaDAO contadao = DAOFactory.getContaDAO();
		CartaoDAO cartaodebitodao = DAOFactory.getCartaoDebitoDAO();
		try {
			Conta conta = contadao.buscar(1); 
			CartaoDebito cartaoDebito = new CartaoDebito(5502495678123434l, "ativo", 0, 1750.00, conta);
			cartaodebitodao.cadastrar(cartaoDebito);
			System.out.println("Cartao de debito cadastrado! ");
		} catch (DBException e) {
			e.printStackTrace();
		}
	}
}
