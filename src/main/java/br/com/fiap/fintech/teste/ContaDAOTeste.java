package br.com.fiap.fintech.teste;

import br.com.fiap.fintech.bean.Conta;
import br.com.fiap.fintech.bean.Usuario;
import br.com.fiap.fintech.dao.ContaDAO;
import br.com.fiap.fintech.dao.UsuarioDAO;
import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.factory.DAOFactory;

public class ContaDAOTeste {
	public static void main(String[] args) {
		ContaDAO contadao = DAOFactory.getContaDAO();
		UsuarioDAO usuariodao = DAOFactory.getUsuarioDAO();
		try {
			Usuario usuario = usuariodao.buscar(1);
			Conta conta = new Conta(3391, 194379, 1750.00, "deposito", usuario);
			contadao.cadastrar(conta);
			System.out.println("Conta cadastrada! ");
		} catch (DBException e) {
			e.printStackTrace();
		}
	}
}
