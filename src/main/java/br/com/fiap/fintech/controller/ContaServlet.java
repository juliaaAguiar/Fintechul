package br.com.fiap.fintech.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.fintech.bean.Conta;
import br.com.fiap.fintech.bean.Usuario;
import br.com.fiap.fintech.dao.ContaDAO;
import br.com.fiap.fintech.dao.UsuarioDAO;
import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.factory.DAOFactory;

@WebServlet("/conta")
public class ContaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ContaServlet() {
        super();
    }
    
    private ContaDAO dao;
    private UsuarioDAO usuarioDao;
    
    @Override
	public void init() throws ServletException {
		super.init();
		dao = DAOFactory.getContaDAO();
		usuarioDao = DAOFactory.getUsuarioDAO();
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
//		case "extrato":
//		extrato(request, response);
//		break;
		}	
	}
    
    private void abrirFormEdicao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			int id = Integer.parseInt(request.getParameter("codigo"));
			Conta conta = dao.buscar(id);
			request.setAttribute("conta", conta);
			request.getRequestDispatcher("conta.jsp").forward(request, response);
	}

//	private void extrato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//			int codigo_conta = Integer.parseInt(request.getParameter("codigo_conta"));
//			request.setAttribute("contaId", codigo_conta);
//			request.getRequestDispatcher("/extrato").forward(request, response);
//	}
    
    private void abrirFormCadastro(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	int codigo_usuario = Integer.parseInt(request.getParameter("codigo_usuario"));
    	Usuario usuario = usuarioDao.buscar(codigo_usuario);
    	request.setAttribute("usuario", usuario);
    	request.getRequestDispatcher("conta.jsp").forward(request, response);
    }
	
	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Conta> lista = dao.listar();
		Conta conta = (Conta) request.getAttribute("conta");
		request.setAttribute("contas", lista);
		request.setAttribute("conta", conta);
		request.getRequestDispatcher("conta.jsp").forward(request, response);
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
    		request.setAttribute("msg", "Conta excluída!");
    	} catch (DBException e) {
    		e.printStackTrace();
    		request.setAttribute("erro", "Erro ao atualizar");
    	}
    	listar(request,response);
    }


    private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try {
    		int codigo_usuario = Integer.parseInt(request.getParameter("codigo_usuario"));
    		Usuario usuario = usuarioDao.buscar(codigo_usuario);
    		int agencia = Integer.parseInt(request.getParameter("agencia"));
    		int numero = Integer.parseInt(request.getParameter("numero"));
    		double saldo = Double.parseDouble(request.getParameter("saldo"));
    		String tipo = request.getParameter("tipo");
			Conta conta = new Conta(agencia, numero, saldo, tipo, usuario);
			dao.atualizar(conta);
			
    		request.setAttribute("msg", "Conta atualizada!");
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
    		int codigo_usuario = Integer.parseInt(request.getParameter("codigo_usuario"));
    		Usuario usuario = usuarioDao.buscar(codigo_usuario);
    		int agencia = Integer.parseInt(request.getParameter("agencia"));
    		int numero = Integer.parseInt(request.getParameter("numero"));
    		double saldo = Double.parseDouble(request.getParameter("saldo"));
    		String tipo = request.getParameter("tipo");
			Conta conta = new Conta(agencia, numero, saldo, tipo, usuario);
			
			dao.cadastrar(conta);
			
			request.setAttribute("msg", "Conta cadastrada!");
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
