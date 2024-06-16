package br.com.fiap.fintech.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.fintech.bean.Pessoa;
import br.com.fiap.fintech.bean.Usuario;
import br.com.fiap.fintech.dao.PessoaDAO;
import br.com.fiap.fintech.dao.UsuarioDAO;
import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.factory.DAOFactory;

@WebServlet("/usuario")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UsuarioDAO dao;
	private PessoaDAO pessoadao;

	
	@Override
	public void init() throws ServletException {
		super.init();
		dao = DAOFactory.getUsuarioDAO();
		pessoadao = DAOFactory.getPessoaDAO();
	}
       
    public UsuarioServlet() {
        super();
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		
		switch (acao) {
		case "abrir-form-edicao":
			abrirFormEdicao(request, response);
		case "abrir-form-cadastro":
			abrirFormCadastro(request, response);
			break;
		}	
	}

	private void abrirFormEdicao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("codigo"));
		Pessoa usuario = dao.buscar(id);
		request.setAttribute("usuario", usuario);
		request.getRequestDispatcher("edicao-pessoa.jsp").forward(request, response);
	}
	
	private void abrirFormCadastro(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	request.getRequestDispatcher("cadastrar.jsp").forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {

    	String acao = request.getParameter("acao");
    	
    	switch (acao) {
    	case "cadastrar":
    		cadastrar(request, response);
    		break;
    	case "editar":
    		editar(request,response);
    		break;
    	case "excluir":
    		excluir(request, response);
    		break;
    	}
    }

    private void excluir(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	int codigo = Integer.parseInt(request.getParameter("codigo"));
    	try {
    		dao.remover(codigo);
    		request.setAttribute("msg", "Usuario removido!");
    	} catch (DBException e) {
    		e.printStackTrace();
    		request.setAttribute("erro", "Erro ao atualizar");
    	}
    	request.getRequestDispatcher("index.jsp").forward(request, response);
    }


    private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try {
			String cpf = request.getParameter("cpf");
			String email = request.getParameter("email");
			String nome = request.getParameter("nome");
			String perfil = request.getParameter("perfil");
			String senha = request.getParameter("senha");
			String telefone = request.getParameter("telefone");
			
			Pessoa pessoa = new Pessoa(nome, cpf, "ativo");
			
			Usuario usuario = new Usuario(email, senha, telefone, perfil, pessoa);
			dao.atualizar(usuario);
			
    		request.setAttribute("msg", "Usuario atualizado!");
    	} catch (DBException db) {
    		db.printStackTrace();
    		request.setAttribute("erro", "Erro ao atualizar");
    	} catch (Exception e) {
    		e.printStackTrace();
    		request.setAttribute("erro", "Por favor, valide os dados");
    	}
    	request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    private void cadastrar(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	try {
			String cpf = request.getParameter("cpf");
			String nome = request.getParameter("nome");
			String email = request.getParameter("email");
			String senha = request.getParameter("senha");
			String telefone = request.getParameter("telefone");
			
			Pessoa pessoa = new Pessoa(nome, cpf, "ativo");
			
			Usuario usuario = new Usuario(email, senha, telefone, "iniciante", pessoa);
			dao.cadastrar(usuario);
			
			request.setAttribute("msg", "Usuario cadastrado!");
    	} catch (DBException db) {
    		db.printStackTrace();
    		request.setAttribute("erro", "Erro ao cadastrar");
    	} catch (Exception e) {
    		e.printStackTrace();
    		request.setAttribute("erro", "Por favor, valide os dados");
    	}
    	request.getRequestDispatcher("cadastrar.jsp").forward(request, response);
    }
}
