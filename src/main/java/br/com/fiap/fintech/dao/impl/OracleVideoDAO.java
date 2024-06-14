package br.com.fiap.fintech.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.fintech.bean.Video;
import br.com.fiap.fintech.dao.VideoDAO;
import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.singleton.ConnectionManager;

public class OracleVideoDAO implements VideoDAO {
	private Connection conexao;

	@Override
	public void atualizar(Video video) throws DBException {
		PreparedStatement statement = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE t_video SET ds_titulo = ?, nm_link = ?, ds_descricao = ? WHERE cd_cod_video = ?";
			statement = conexao.prepareStatement(sql);
			statement.setNString(1, video.getTitulo());
			statement.setNString(2, video.getLink());
			statement.setNString(3, video.getDescricao());
			statement.setInt(4, video.getCodigo());
			
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("Erro ao atualizar video. ");
		} finally {
			try {
				statement.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void cadastrar(Video video) throws DBException {
		PreparedStatement statement = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO t_video (cd_cod_video, ds_titulo, nm_link, ds_descricao) VALUES (sq_video.nextval, ?, ?, ?)";
			statement = conexao.prepareStatement(sql);
			statement.setNString(1, video.getTitulo());
			statement.setNString(2, video.getLink());
			statement.setNString(3, video.getDescricao());
			
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("Erro ao criar video. ");
		} finally {
			try {
				statement.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void remover(int codigo) throws DBException {
		PreparedStatement statement = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "DELETE FROM t_video WHERE cd_cod_video = ?";
			statement = conexao.prepareStatement(sql);
			statement.setInt(1, codigo);
			
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("Erro ao excluir video. ");
		} finally {
			try {
				statement.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public Video buscar(int id) {
		Video video = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			statement = conexao.prepareStatement("SELECT * FROM t_video WHERE cd_cod_video = ?");
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			
			if (resultSet.next()) {
				int codigo = resultSet.getInt("cd_cod_video");
				String descricao = resultSet.getNString("ds_descricao");
				String link = resultSet.getNString("nm_link");
				String titulo = resultSet.getNString("ds_titulo");
				
				video = new Video(codigo, descricao, link, titulo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				resultSet.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return video;
	}

	@Override
	public List<Video> listar() {
		List<Video> lista = new ArrayList<Video>();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			statement = conexao.prepareStatement("SELECT * FROM t_video");
			resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				int codigo = resultSet.getInt("cd_cod_video");
				String descricao = resultSet.getNString("ds_descricao");
				String link = resultSet.getNString("nm_link");
				String titulo = resultSet.getNString("ds_titulo");
				
				Video video = new Video(codigo, descricao, link, titulo);
				lista.add(video);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				resultSet.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lista;
	}
}
