package br.com.fiap.fintech.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.fintech.bean.Ativo;
import br.com.fiap.fintech.dao.AtivoDAO;
import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.factory.DAOFactory;

@WebServlet("/ativo")
public class AtivoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private AtivoDAO dao;
	
	@Override
	public void init() throws ServletException {
		super.init();
		dao = DAOFactory.getAtivoDAO();
	}
       
    public AtivoServlet() {
        super();
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		
		switch (acao) {
		case "listar":
			listar(request, response);
		case "abrir-form-edicao":
			abrirFormEdicao(request, response);
		}	
	}

	private void abrirFormEdicao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("codigo"));
		Ativo ativo = dao.buscar(id);
		request.setAttribute("ativo", ativo);
		request.getRequestDispatcher("edicao-ativo.jsp").forward(request, response);
	}
	
	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Ativo> lista = dao.listar();
		request.setAttribute("ativos", lista);
		request.getRequestDispatcher("lista-ativo.jsp").forward(request, response);
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
    		request.setAttribute("msg", "Ativo removido!");
    	} catch (DBException e) {
    		e.printStackTrace();
    		request.setAttribute("erro", "Erro ao atualizar");
    	}
    	listar(request,response);    
    }


    private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try {
			String nome = request.getParameter("nome");
			String tipo = request.getParameter("email");
    		double valor = Double.parseDouble(request.getParameter("valor"));
    		Ativo ativo = new Ativo(nome, tipo, valor);
			dao.atualizar(ativo);
			
    		request.setAttribute("msg", "Ativo atualizado!");
    	} catch (DBException db) {
    		db.printStackTrace();
    		request.setAttribute("erro", "Erro ao atualizar");
    	} catch (Exception e) {
    		e.printStackTrace();
    		request.setAttribute("erro", "Por favor, valide os dados");
    	}
    	listar(request,response);        
    }

    private void cadastrar(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	try {
    		String nome = request.getParameter("nome");
			String tipo = request.getParameter("email");
    		double valor = Double.parseDouble(request.getParameter("valor"));
    		Ativo ativo = new Ativo(nome, tipo, valor);
			
			dao.cadastrar(ativo);
			
			request.setAttribute("msg", "Ativo cadastrado!");
    	} catch (DBException db) {
    		db.printStackTrace();
    		request.setAttribute("erro", "Erro ao cadastrar");
    	} catch (Exception e) {
    		e.printStackTrace();
    		request.setAttribute("erro", "Por favor, valide os dados");
    	}
    	listar(request,response);        
    }
}
