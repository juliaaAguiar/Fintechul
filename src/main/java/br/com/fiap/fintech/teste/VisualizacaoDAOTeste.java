package br.com.fiap.fintech.teste;

import br.com.fiap.fintech.bean.Usuario;
import br.com.fiap.fintech.bean.Video;
import br.com.fiap.fintech.bean.Visualizacao;
import br.com.fiap.fintech.dao.UsuarioDAO;
import br.com.fiap.fintech.dao.VideoDAO;
import br.com.fiap.fintech.dao.VisualizacaoDAO;
import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.factory.DAOFactory;

public class VisualizacaoDAOTeste {
	public static void main(String[] args) {
		VideoDAO videodao = DAOFactory.getVideoDAO();
		UsuarioDAO usuariodao = DAOFactory.getUsuarioDAO();
		VisualizacaoDAO visualizacaodao = DAOFactory.getVisualizacaoDAO();
		try {
			Usuario usuario = usuariodao.buscar(1);
			Video video = videodao.buscar(3);
			java.util.Date dataUtil = new java.util.Date();
			java.sql.Date data = new java.sql.Date(dataUtil.getTime());
			Visualizacao visualizacao = new Visualizacao(usuario, video, data);
			visualizacaodao.cadastrar(visualizacao);
			System.out.println("Visualizacao registrada! ");
		} catch (DBException e) {
			e.printStackTrace();
		}
	}
}
