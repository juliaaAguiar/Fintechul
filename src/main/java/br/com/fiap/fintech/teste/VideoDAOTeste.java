package br.com.fiap.fintech.teste;

import br.com.fiap.fintech.bean.Video;
import br.com.fiap.fintech.dao.VideoDAO;
import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.factory.DAOFactory;

public class VideoDAOTeste {
	public static void main(String[] args) {
		VideoDAO videodao = DAOFactory.getVideoDAO();
		Video video = new Video("musica pra chora", "https://www.youtube.com/watch?v=3XqqkrJENB4", "Cigarettes After Sex - Cry");
		try {
			videodao.cadastrar(video);
			System.out.println("Video cadastrado! ");
		} catch (DBException e) {
			e.printStackTrace();
		}
	}
}
