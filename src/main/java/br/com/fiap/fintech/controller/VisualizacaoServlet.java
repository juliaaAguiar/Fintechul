package br.com.fiap.fintech.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.fintech.bean.Usuario;
import br.com.fiap.fintech.bean.Video;
import br.com.fiap.fintech.bean.Visualizacao;
import br.com.fiap.fintech.dao.UsuarioDAO;
import br.com.fiap.fintech.dao.VideoDAO;
import br.com.fiap.fintech.dao.VisualizacaoDAO;
import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.factory.DAOFactory;

@WebServlet("/VisualizacaoServlet")
public class VisualizacaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public VisualizacaoServlet() {
        super();
    }
    
    private VisualizacaoDAO dao;
    private VideoDAO videoDao;
    private UsuarioDAO usuarioDao;
    
    @Override
	public void init() throws ServletException {
		super.init();
		dao = DAOFactory.getVisualizacaoDAO();
		videoDao = DAOFactory.getVideoDAO();
		usuarioDao = DAOFactory.getUsuarioDAO();
	}

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		
		switch (acao) {
		case "visualizar":
			visualizar(request, response);
			break;
		}	
	}
    
    private void visualizar(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	int codigo_usuario = Integer.parseInt(request.getParameter("codigo_usuario"));
    	Usuario usuario = usuarioDao.buscar(codigo_usuario);
    	int codigo_video = Integer.parseInt(request.getParameter("codigo_video"));
    	Video video = videoDao.buscar(codigo_video);
    	request.setAttribute("usuario", usuario);
    	request.setAttribute("video", video);
    	cadastrar(request, response);
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	String acao = request.getParameter("acao");
    	
    	switch (acao) {
    	case "cadastrar":
    		cadastrar(request, response);
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
    		request.setAttribute("msg", "Visualizacao excluída!");
    	} catch (DBException e) {
    		e.printStackTrace();
    		request.setAttribute("erro", "Erro ao atualizar");
    	}
    }


    private void cadastrar(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	try {
    		int codigo_usuario = Integer.parseInt(request.getParameter("codigo_usuario"));
        	Usuario usuario = usuarioDao.buscar(codigo_usuario);
        	int codigo_video = Integer.parseInt(request.getParameter("codigo_video"));
        	Video video = videoDao.buscar(codigo_video);
			java.util.Date dataUtil = new java.util.Date();
			java.sql.Date data = new java.sql.Date(dataUtil.getTime());
			Visualizacao visualizacao = new Visualizacao(usuario, video, data);
			
			dao.cadastrar(visualizacao);
			
			request.setAttribute("msg", "Visualização cadastrada!");
    	} catch (DBException db) {
    		db.printStackTrace();
    		request.setAttribute("erro", "Erro ao cadastrar");
    	} catch (Exception e) {
    		e.printStackTrace();
    		request.setAttribute("erro", "Por favor, valide os dados");
    	}
    }
}
