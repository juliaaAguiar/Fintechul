package br.com.fiap.fintech.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.fintech.bean.Ativo;
import br.com.fiap.fintech.bean.CarteiraInvestimento;
import br.com.fiap.fintech.bean.Investimento;
import br.com.fiap.fintech.dao.AtivoDAO;
import br.com.fiap.fintech.dao.CarteiraInvestimentoDAO;
import br.com.fiap.fintech.dao.InvestimentoDAO;
import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.factory.DAOFactory;

@WebServlet("/investimento")
public class InvestimentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InvestimentoServlet() {
        super();
    }

    private InvestimentoDAO dao;
    private CarteiraInvestimentoDAO carteiraDao;
    private AtivoDAO ativoDao;
    
    @Override
	public void init() throws ServletException {
		super.init();
		dao = DAOFactory.getInvestimentoDAO();
		carteiraDao = DAOFactory.getCarteiraInvestimentoDAO();
		ativoDao = DAOFactory.getAtivoDAO();
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
			int codigo_carteira = Integer.parseInt(request.getParameter("codigo_carteira"));
			int codigo_ativo = Integer.parseInt(request.getParameter("codigo_ativo"));
			Investimento investimento = dao.buscar(codigo_ativo, codigo_carteira);
			request.setAttribute("investimento", investimento);
			request.getRequestDispatcher("edicao-carteira.jsp").forward(request, response);
	}
    
    private void abrirFormCadastro(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	int codigo_ativo = Integer.parseInt(request.getParameter("codigo_ativo"));    	
    	int codigo_carteira = Integer.parseInt(request.getParameter("codigo_carteira"));
		CarteiraInvestimento carteira = carteiraDao.buscar(codigo_carteira);
		Ativo ativo = ativoDao.buscar(codigo_ativo);
    	request.setAttribute("ativo", ativo);
    	request.setAttribute("carteira", carteira);
    	request.getRequestDispatcher("cadastro-investimento.jsp").forward(request, response);
    }
	
	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Investimento> lista = dao.listar();
		request.setAttribute("investimentos", lista);
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
    	case "excluir":
    		excluir(request, response);
    		break;
    	}
    }

    private void excluir(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	int codigo_ativo = Integer.parseInt(request.getParameter("codigo_ativo"));    	
    	int codigo_carteira = Integer.parseInt(request.getParameter("codigo_carteira"));
    	try {
    		Investimento investimento = dao.buscar(codigo_ativo, codigo_carteira);
    		dao.remover(investimento);
    		request.setAttribute("msg", "Investimento excluído!");
    	} catch (DBException e) {
    		e.printStackTrace();
    		request.setAttribute("erro", "Erro ao atualizar");
    	}
    }
    
    private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try {
    		int codigo_ativo = Integer.parseInt(request.getParameter("codigo_ativo"));    	
        	int codigo_carteira = Integer.parseInt(request.getParameter("codigo_carteira"));
        	Ativo ativo = ativoDao.buscar(codigo_ativo);
    		CarteiraInvestimento carteira = carteiraDao.buscar(codigo_carteira);
			java.util.Date dataUtil = new java.util.Date();
			java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());
			int quantidade = Integer.parseInt(request.getParameter("quantidade"));    	;
			Investimento investimento = new Investimento(ativo, carteira, dataSql, quantidade);
			dao.atualizar(investimento);
			
    		request.setAttribute("msg", "Investimento atualizado!");
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
    		int codigo_ativo = Integer.parseInt(request.getParameter("codigo_ativo"));    	
        	int codigo_carteira = Integer.parseInt(request.getParameter("codigo_carteira"));
        	Ativo ativo = ativoDao.buscar(codigo_ativo);
    		CarteiraInvestimento carteira = carteiraDao.buscar(codigo_carteira);
			java.util.Date dataUtil = new java.util.Date();
			java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());
			int quantidade = Integer.parseInt(request.getParameter("quantidade"));    	;
			Investimento investimento = new Investimento(ativo, carteira, dataSql, quantidade);
			
			dao.cadastrar(investimento);
			
			request.setAttribute("msg", "Investimento cadastrado!");
    	} catch (DBException db) {
    		db.printStackTrace();
    		request.setAttribute("erro", "Erro ao cadastrar");
    	} catch (Exception e) {
    		e.printStackTrace();
    		request.setAttribute("erro", "Por favor, valide os dados");
    	}
    }
}
