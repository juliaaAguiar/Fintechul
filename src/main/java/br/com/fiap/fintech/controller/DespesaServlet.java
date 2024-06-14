package br.com.fiap.fintech.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.fintech.bean.Cartao;
import br.com.fiap.fintech.bean.Despesa;
import br.com.fiap.fintech.dao.CartaoDAO;
import br.com.fiap.fintech.dao.DespesaDAO;
import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.factory.DAOFactory;

@WebServlet("/despesa")
public class DespesaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DespesaServlet() {
        super();
    }

    private CartaoDAO cartaoDao;
    private DespesaDAO dao;
    
    @Override
	public void init() throws ServletException {
		super.init();
		cartaoDao = DAOFactory.getCartaoDAO();
		dao = DAOFactory.getDespesaDAO();
	}

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		
		switch (acao) {
		case "listar":
			listar(request, response);
			break;
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
			Despesa despesa = dao.buscar(id);
			request.setAttribute("despesa", despesa);
			request.getRequestDispatcher("edicao-despesa.jsp").forward(request, response);
	}
	
	private void abrirFormCadastro(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	int codigo_cartao = Integer.parseInt(request.getParameter("codigo_cartao"));
    	Cartao cartao = cartaoDao.buscar(codigo_cartao);
    	request.setAttribute("conta", cartao);
    	request.getRequestDispatcher("cadastro-despesa.jsp").forward(request, response);
    }
	
	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Despesa> lista = dao.listar();
		request.setAttribute("despesas", lista);
		request.getRequestDispatcher("lista-despesa.jsp").forward(request, response);
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
    		request.setAttribute("msg", "Despesa excluída!");
    	} catch (DBException e) {
    		e.printStackTrace();
    		request.setAttribute("erro", "Erro ao atualizar");
    	}
    	listar(request,response);
    }


    private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try {
    		int codigo_cartao = Integer.parseInt(request.getParameter("codigo_cartao"));
        	Cartao cartao = cartaoDao.buscar(codigo_cartao);
			java.util.Date dataUtil = new java.util.Date();
			java.sql.Date data = new java.sql.Date(dataUtil.getTime());
			double valor = Double.parseDouble(request.getParameter("valor"));
			Despesa despesa = new Despesa(data, valor, cartao);
			dao.atualizar(despesa);
			
    		request.setAttribute("msg", "Despesa atualizada!");
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
    		int codigo_cartao = Integer.parseInt(request.getParameter("codigo_cartao"));
        	Cartao cartao = cartaoDao.buscar(codigo_cartao);
			java.util.Date dataUtil = new java.util.Date();
			java.sql.Date data = new java.sql.Date(dataUtil.getTime());
			double valor = Double.parseDouble(request.getParameter("valor"));
			Despesa despesa = new Despesa(data, valor, cartao);
			
			dao.cadastrar(despesa);
			
			request.setAttribute("msg", "Despesa cadastrada!");
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
