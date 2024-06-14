package br.com.fiap.fintech.controller;

import java.io.IOException;
<<<<<<< HEAD

import java.util.List;

=======
>>>>>>> c1c582d6fbd2dc22fe519e2a9f10ed60edc8f5e9
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

<<<<<<< HEAD
import br.com.fiap.fintech.bean.Video;
import br.com.fiap.fintech.dao.VideoDAO;
import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.factory.DAOFactory;

@WebServlet("/AtivoServlet")
public class VideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   private VideoDAO dao;
   
   
   public void init() throws ServletException{
	   super.init();

	   dao = DAOFactory.getVideoDAO();
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
	   Video video = dao.buscar(id);
	   request.setAttribute("video", video);
	   request.getRequestDispatcher("video.jsp").forward(request,response);
	   
	}


	
	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Video> lista = dao.listar();
		request.setAttribute("video", lista);
		request.getRequestDispatcher("video.jsp").forward(request,response);
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

	private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			String titulo = request.getParameter("titulo");
			String link = request.getParameter("link");			
			String descricao = request.getParameter("descricao");
			

			Video video = new Video(0,titulo, link,descricao);
			dao.cadastrar(video);

			request.setAttribute("msg", "Video Cadastrado");	
			
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
			String titulo = request.getParameter("titulo");
			String link = request.getParameter("link");			
			String descricao = request.getParameter("descricao");			

			
			Video video = new Video(codigo,titulo, link,descricao);
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
	
	
=======
@WebServlet("/video")
public class VideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public VideoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
>>>>>>> c1c582d6fbd2dc22fe519e2a9f10ed60edc8f5e9
