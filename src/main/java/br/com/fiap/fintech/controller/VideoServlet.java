package br.com.fiap.fintech.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.fintech.bean.Video;
import br.com.fiap.fintech.dao.VideoDAO;
import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.factory.DAOFactory;

@WebServlet("/video")
public class VideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public VideoServlet() {
        super();
    }

    private VideoDAO dao;
	
	@Override
	public void init() throws ServletException {
		super.init();
		dao = DAOFactory.getVideoDAO();
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
		Video video = dao.buscar(id);
		request.setAttribute("video", video);
		request.getRequestDispatcher("edicao-video.jsp").forward(request, response);
	}
	
	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Video> lista = dao.listar();
		request.setAttribute("videos", lista);
		request.getRequestDispatcher("lista-video.jsp").forward(request, response);
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
    		request.setAttribute("msg", "Video removido!");
    	} catch (DBException e) {
    		e.printStackTrace();
    		request.setAttribute("erro", "Erro ao atualizar");
    	}
    	listar(request,response);    
    }


    private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try {
    		String nome = request.getParameter("nome");
    		String link = request.getParameter("link");
    		String descricao = request.getParameter("descricao"); 
    		Video video = new Video(descricao, link, nome);
			dao.atualizar(video);
			
    		request.setAttribute("msg", "Video atualizado!");
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
    		String link = request.getParameter("link");
    		String descricao = request.getParameter("descricao"); 
    		Video video = new Video(descricao, link, nome);
			
			dao.cadastrar(video);
			
			request.setAttribute("msg", "Video cadastrado!");
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
