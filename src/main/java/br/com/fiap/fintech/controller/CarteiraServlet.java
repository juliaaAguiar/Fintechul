package br.com.fiap.fintech.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.fintech.bean.CarteiraInvestimento;
import br.com.fiap.fintech.bean.Conta;
import br.com.fiap.fintech.dao.CarteiraInvestimentoDAO;
import br.com.fiap.fintech.dao.ContaDAO;
import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.factory.DAOFactory;

@WebServlet("/carteira")
public class CarteiraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CarteiraServlet() {
        super();
    }

    private ContaDAO contaDao;
    private CarteiraInvestimentoDAO dao;
	
	@Override
	public void init() throws ServletException {
		super.init();
		contaDao = DAOFactory.getContaDAO();
		dao = DAOFactory.getCarteiraInvestimentoDAO();
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
			CarteiraInvestimento carteira = dao.buscar(id);
			request.setAttribute("carteira", carteira);
			request.getRequestDispatcher("edicao-carteira.jsp").forward(request, response);
	}
	
	private void abrirFormCadastro(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
		int codigo_conta = Integer.parseInt(request.getParameter("codigo_conta"));
    	Conta conta = contaDao.buscar(codigo_conta);
    	request.setAttribute("conta", conta);
    	request.getRequestDispatcher("cadastro-conta.jsp").forward(request, response);
    }
	
	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<CarteiraInvestimento> lista = dao.listar();
		request.setAttribute("carteiras", lista);
		request.getRequestDispatcher("lista-carteira.jsp").forward(request, response);
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
    		request.setAttribute("msg", "Carteira de investimento excluída!");
    	} catch (DBException e) {
    		e.printStackTrace();
    		request.setAttribute("erro", "Erro ao atualizar");
    	}
    	listar(request,response);
    }


    private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try {
    		ContaDAO contadao = DAOFactory.getContaDAO();
    		int conta_id = Integer.parseInt(request.getParameter("codigo_conta"));
    		String nome = request.getParameter("nome");
    		Conta conta = contadao.buscar(conta_id);
			CarteiraInvestimento carteira = new CarteiraInvestimento(nome, conta);
			dao.atualizar(carteira);
			
    		request.setAttribute("msg", "Carteira de investimento atualizada!");
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
    		ContaDAO contadao = DAOFactory.getContaDAO();
    		int conta_id = Integer.parseInt(request.getParameter("codigo_conta"));
    		String nome = request.getParameter("nome");
    		Conta conta = contadao.buscar(conta_id);
			CarteiraInvestimento carteira = new CarteiraInvestimento(nome, conta);
			
			dao.cadastrar(carteira);
			
			request.setAttribute("msg", "Carteira de investimento cadastrada!");
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
