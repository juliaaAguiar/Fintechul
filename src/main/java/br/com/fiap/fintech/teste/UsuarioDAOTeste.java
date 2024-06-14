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
	    Pessoa pessoa = new Pessoa("Pedro", "01357894946", "ativo");	    
	    try {
	        int pessoaId = pessoadao.cadastrar(pessoa);  
	        Usuario usuario = new Usuario("pedro@gmail.com", "pedro123", "45991035957", "iniciante", pessoa);
	        usuario.setCodigoPessoa(pessoaId);
	        usuariodao.cadastrar(usuario);  
	        System.out.println("Usuario cadastrado!");
	    } catch (DBException e) {
	        e.printStackTrace();
	    }
	}
}
