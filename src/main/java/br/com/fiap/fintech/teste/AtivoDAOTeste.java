package br.com.fiap.fintech.teste;

import br.com.fiap.fintech.bean.Ativo;
import br.com.fiap.fintech.dao.AtivoDAO;
import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.factory.DAOFactory;

public class AtivoDAOTeste {
	public static void main(String[] args) {
		AtivoDAO ativodao = DAOFactory.getAtivoDAO();
		try {
			Ativo ativo = new Ativo("IC26A", "renda fixa", 16.50);
			ativodao.cadastrar(ativo);
			System.out.println("Ativo cadastrado! ");
		} catch (DBException e) {
			e.printStackTrace();
		}
	}
}
