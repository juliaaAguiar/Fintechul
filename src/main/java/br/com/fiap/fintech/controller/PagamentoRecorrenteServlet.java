package br.com.fiap.fintech.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.fintech.bean.Conta;
import br.com.fiap.fintech.bean.PagamentoRecorrente;
import br.com.fiap.fintech.dao.ContaDAO;
import br.com.fiap.fintech.dao.PagamentoRecorrenteDAO;
import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.factory.DAOFactory;

@WebServlet("/pagamentoRecorrente")
public class PagamentoRecorrenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PagamentoRecorrenteServlet() {
        super();
    }
    
    private ContaDAO contaDao;
    private PagamentoRecorrenteDAO dao;
	
	@Override
	public void init() throws ServletException {
		super.init();
		contaDao = DAOFactory.getContaDAO();
		dao = DAOFactory.getPagamentoRecorrenteDAO();
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
		PagamentoRecorrente pagamento = dao.buscar(id);
		request.setAttribute("pagamento", pagamento);
		request.getRequestDispatcher("edicao-pagamentorecorrente.jsp").forward(request, response);
	}
	
	private void abrirFormCadastro(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
		int codigo_conta = Integer.parseInt(request.getParameter("codigo_conta"));
    	Conta conta = contaDao.buscar(codigo_conta);
    	request.setAttribute("conta", conta);
    	request.getRequestDispatcher("cadastrarRecDes.jsp").forward(request, response);
    }
	
	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<PagamentoRecorrente> lista = dao.listar();
		request.setAttribute("pagamentosRecorrentes", lista);
		request.getRequestDispatcher("extrato.jsp").forward(request, response);
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
    		request.setAttribute("msg", "Pagamento recorrente removido!");
    	} catch (DBException e) {
    		e.printStackTrace();
    		request.setAttribute("erro", "Erro ao atualizar");
    	}
    	listar(request,response);    
    }


    private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try {
    		int conta_id = Integer.parseInt(request.getParameter("codigo_conta"));
    		Conta conta = contaDao.buscar(conta_id);
			java.util.Date dataUtil = new java.util.Date();
			java.sql.Date data = new java.sql.Date(dataUtil.getTime());
			String nome = request.getParameter("nome");
			double valor = Double.parseDouble(request.getParameter("valor"));
			PagamentoRecorrente pagamentoRecorrente = new PagamentoRecorrente(data, nome, valor, conta);
    		
			dao.atualizar(pagamentoRecorrente);
			
    		request.setAttribute("msg", "Pagamento recorrente atualizado!");
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
    		Conta conta = contaDao.buscar(conta_id);
			Date dataUtil = Date.parse(request.getParameter("data"));
			java.sql.Date data = new java.sql.Date(dataUtil.getTime());
			String nome = request.getParameter("nome");
			double valor = Double.parseDouble(request.getParameter("valor"));
			PagamentoRecorrente pagamentoRecorrente = new PagamentoRecorrente(data, nome, valor, conta);
			
			dao.cadastrar(pagamentoRecorrente);
			
			request.setAttribute("msg", "Pagamento recorrente cadastrado!");
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
