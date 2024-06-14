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

@WebServlet("/AtivoServlet")

public class AtivoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   private AtivoDAO dao;
   
   
   public void init() throws ServletException{
	   super.init();

	   dao = DAOFactory.getAtivoDAO();
   }

   @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
	   String acao = request.getParameter("acao");

	   switch(acao){
		   case "listar":
			   listar(request, response);	
			   break;
		   
		   case "abri-form-edicao":
			   abrirFormEdicao(request,response);
			   break;
			   
	   }

	}
   
   private void abrirFormEdicao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   
	   int id = Integer.parseInt(request.getParameter("codigo"));		
	   Ativo ativo = dao.buscar(id);
	   request.setAttribute("ativo", ativo);
	   request.getRequestDispatcher("editar_ativo.jsp").forward(request,response);
	   
	}


	
	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Ativo> lista = dao.listar();
		request.setAttribute("ativo", lista);
		request.getRequestDispatcher("listaAtivo.jsp").forward(request,response);
	}
		
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acao = request.getParameter("acao");
		
		switch (acao) {
		case "cadastrar":
			cadastrar(request, response);
			break;
		case "editar":
			editar(request,response);
			break;
		case "excluir":
			excluir(request,response);
			break;
		}

	}


	private void cadastrar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			
			String tipo = request.getParameter("tipo");
			String nome = request.getParameter("nome");
			double valorAtual = Double.parseDouble(request.getParameter("valorAtual"));
			String descricao = request.getParameter("descricao");

			Ativo ativo = new Ativo(0,tipo,nome,valorAtual,descricao);
			dao.cadastrar(ativo);

			request.setAttribute("msg", "Ativo Cadastrado");	
			
		}catch(DBException db){
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao cadastrar");
		}catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", "Por favor, confirmar os dados");
		}
		
		request.getRequestDispatcher("listaAtivo.jsp").forward(request,response);
	}
	
	private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int codigo = Integer.parseInt(request.getParameter("codigo"));
			String tipo = request.getParameter("tipo");
			String nome = request.getParameter("nome");
			double valorAtual = Double.parseDouble(request.getParameter("valorAtual"));
			String descricao = request.getParameter("descricao");
			
			Ativo ativo = new Ativo(codigo,tipo, nome, valorAtual, descricao);
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
	
	private void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int codigo = Integer.parseInt(request.getParameter("codigo"));

		try{
			dao.remover(codigo);
			request.setAttribute("msg", "Ativo excluido");
		}catch(DBException e) {
			e.printStackTrace();
			request.setAttribute("erro", "Erro ao excluir");
		}

		listar(request,response);
	}	
	
}	
	
	

