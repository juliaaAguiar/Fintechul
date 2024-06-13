package br.com.fiap.fintech.teste;

import br.com.fiap.fintech.bean.Pessoa;
import br.com.fiap.fintech.bean.Usuario;
import br.com.fiap.fintech.dao.PessoaDAO;
import br.com.fiap.fintech.dao.UsuarioDAO;
import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.factory.DAOFactory;

public class UsuarioDAOTeste {
	public static void main(String[] args) {
		UsuarioDAO usuariodao = DAOFactory.getUsuarioDAO();
		PessoaDAO pessoadao = DAOFactory.getPessoaDAO();
		double cpf = 00680474951D;
		Pessoa pessoa = new Pessoa("Sabrina", cpf, "ativo");
		try {
			pessoadao.cadastrar(pessoa);
			Usuario usuario = new Usuario("pedro@gmail.com", "pedro123", "45991035957", "iniciante", pessoa);
			usuariodao.cadastrar(usuario);
			System.out.println("Usuario cadastrado! ");
			// TODO: no banco está cortando os 0s à esquerda. 
		} catch (DBException e) {
			e.printStackTrace();
		}
	}
}
