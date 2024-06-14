package br.com.fiap.fintech.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.fintech.bean.Conta;
import br.com.fiap.fintech.bean.Deposito;
import br.com.fiap.fintech.dao.ContaDAO;
import br.com.fiap.fintech.dao.DepositoDAO;
import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.factory.DAOFactory;

@WebServlet("/deposito")
public class DepositoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DepositoServlet() {
        super();
    }
    
    private ContaDAO contaDao;
    private DepositoDAO dao;
    
    @Override
	public void init() throws ServletException {
		super.init();
		contaDao = DAOFactory.getContaDAO();
		dao = DAOFactory.getDepositoDAO();
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
			Deposito deposito = dao.buscar(id);
			request.setAttribute("carteira", deposito);
			request.getRequestDispatcher("edicao-deposito.jsp").forward(request, response);
	}
	
	private void abrirFormCadastro(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	int codigo_conta = Integer.parseInt(request.getParameter("codigo_conta"));
    	Conta conta = contaDao.buscar(codigo_conta);
    	request.setAttribute("conta", conta);
    	request.getRequestDispatcher("cadastro-deposito.jsp").forward(request, response);
    }
	
	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Deposito> lista = dao.listar();
		request.setAttribute("depositos", lista);
		request.getRequestDispatcher("lista-deposito.jsp").forward(request, response);
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
    		request.setAttribute("msg", "Deposito excluído!");
    	} catch (DBException e) {
    		e.printStackTrace();
    		request.setAttribute("erro", "Erro ao atualizar");
    	}
    	listar(request,response);
    }


    private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try {
    		int codigo_conta = Integer.parseInt(request.getParameter("codigo_conta"));
        	Conta conta = contaDao.buscar(codigo_conta);
			java.util.Date dataUtil = new java.util.Date();
			java.sql.Date data = new java.sql.Date(dataUtil.getTime());
			double valor = Double.parseDouble(request.getParameter("valor"));
			Deposito deposito = new Deposito(data, valor, conta);
			dao.atualizar(deposito);
			
    		request.setAttribute("msg", "Deposito atualizado!");
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
    		int codigo_conta = Integer.parseInt(request.getParameter("codigo_conta"));
        	Conta conta = contaDao.buscar(codigo_conta);
			java.util.Date dataUtil = new java.util.Date();
			java.sql.Date data = new java.sql.Date(dataUtil.getTime());
			double valor = Double.parseDouble(request.getParameter("valor"));
			Deposito deposito = new Deposito(data, valor, conta);
			
			dao.cadastrar(deposito);
			
			request.setAttribute("msg", "Deposito cadastrado!");
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
