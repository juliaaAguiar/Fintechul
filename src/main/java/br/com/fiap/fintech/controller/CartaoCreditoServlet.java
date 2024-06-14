package br.com.fiap.fintech.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.fintech.bean.Cartao;
import br.com.fiap.fintech.bean.CartaoCredito;
import br.com.fiap.fintech.bean.Conta;
import br.com.fiap.fintech.dao.CartaoDAO;
import br.com.fiap.fintech.dao.ContaDAO;
import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.factory.DAOFactory;

@WebServlet("/cartaocredito")
public class CartaoCreditoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	private ContaDAO contadao;
	private CartaoDAO dao;
	
	@Override
	public void init() throws ServletException {
		super.init();
		contadao = DAOFactory.getContaDAO();
		dao = DAOFactory.getCartaoCreditoDAO();
	}
       
    public CartaoCreditoServlet() {
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
		case "abrir-form-cadastro":
			abrirFormCadastro(request, response);
			break;
		}	
	}

	private void abrirFormEdicao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			int id = Integer.parseInt(request.getParameter("codigo"));
			Cartao cartao = dao.buscar(id);
			request.setAttribute("cartao", cartao);
			request.getRequestDispatcher("edicao-cartao.jsp").forward(request, response);
	}
	
	private void abrirFormCadastro(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	int codigo_cartao = Integer.parseInt(request.getParameter("codigo_cartao"));
    	Cartao cartao = dao.buscar(codigo_cartao);
    	request.setAttribute("conta", cartao);
    	request.getRequestDispatcher("cadastro-cartao.jsp").forward(request, response);
    }
	
	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Cartao> lista = dao.listar();
		request.setAttribute("cartoes", lista);
		request.getRequestDispatcher("lista-cartao.jsp").forward(request, response);
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
    		request.setAttribute("msg", "Cartão de crédito removido!");
    	} catch (DBException e) {
    		e.printStackTrace();
    		request.setAttribute("erro", "Erro ao atualizar");
    	}
    	listar(request,response);
    }


    private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try {
    		int conta_id = Integer.parseInt(request.getParameter("codigo_conta"));
    		int diaVencimentoFatura = Integer.parseInt(request.getParameter("vencimento"));
    		double limite = Double.parseDouble(request.getParameter("limite"));
			long numero = Long.parseLong(request.getParameter("numero"));
			int virtual = Integer.parseInt(request.getParameter("virtual"));
			
			Conta conta = contadao.buscar(conta_id); 
			
			CartaoCredito cartaoCredito = new CartaoCredito(numero, "ativo", virtual, conta, diaVencimentoFatura, limite);
			
			dao.atualizar(cartaoCredito);
			
    		request.setAttribute("msg", "Cartão de crédito atualizado!");
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
    		int conta_id = Integer.parseInt(request.getParameter("codigo_conta"));
    		int diaVencimentoFatura = Integer.parseInt(request.getParameter("vencimento"));
    		double limite = Double.parseDouble(request.getParameter("limite"));
			long numero = Long.parseLong(request.getParameter("numero"));
			int virtual = Integer.parseInt(request.getParameter("virtual"));
			
			Conta conta = contadao.buscar(conta_id); 
			
			CartaoCredito cartaoCredito = new CartaoCredito(numero, "ativo", virtual, conta, diaVencimentoFatura, limite);
			
			dao.cadastrar(cartaoCredito);
			
			request.setAttribute("msg", "Cartão de crédito cadastrado!");
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
