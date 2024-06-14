package br.com.fiap.fintech.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.fintech.bean.Visualizacao;
import br.com.fiap.fintech.dao.VisualizacaoDAO;
import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.singleton.ConnectionManager;

public class OracleVisualizacaoDAO implements VisualizacaoDAO {
	private Connection conexao;

	@Override
	public void atualizar(Visualizacao visualizacao) throws DBException {
		PreparedStatement statement = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE t_visu SET dt_visualizacao = ? WHERE cd_visualizacao = ?";
			statement = conexao.prepareStatement(sql);
			statement.setDate(1, visualizacao.getData());
			statement.setInt(2, visualizacao.getCodigo());
			
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("Erro ao atualizar visualizacao. ");
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
	public void cadastrar(Visualizacao visualizacao) throws DBException {
		PreparedStatement statement = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO t_visu (cd_visualizacao, cd_login, cd_cod_video, dt_visualizacao) VALUES (sq_visualizacoes.nextval, ?, ?, ?)";
			statement = conexao.prepareStatement(sql);
			statement.setInt(1, visualizacao.getUsuario().getCodigo());
			statement.setInt(2, visualizacao.getVideo().getCodigo());
			statement.setDate(3, visualizacao.getData());
			
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("Erro ao cadastrar visualizacao. ");
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
			String sql = "DELETE FROM t_visu WHERE cd_visualizacao = ?";
			statement = conexao.prepareStatement(sql);
			statement.setInt(1, codigo);
			
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("Erro ao excluir visualizacao. ");
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
	public Visualizacao buscar(int id) {
		Visualizacao visualizacao = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			statement = conexao.prepareStatement("SELECT * FROM t_visu WHERE cd_visualizacao = ?");
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			
			if (resultSet.next()) {
				int codigo = resultSet.getInt("cd_visualizacao");
				int codigo_usuario = resultSet.getInt("cd_login");
				int codigo_video = resultSet.getInt("cd_cod_video");
				Date data = resultSet.getDate("dt_data");
				
				visualizacao = new Visualizacao(codigo, codigo_usuario, codigo_video, data);
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
		return visualizacao;
	}

	@Override
	public List<Visualizacao> listar() {
		List<Visualizacao> lista = new ArrayList<Visualizacao>();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			statement = conexao.prepareStatement("SELECT * FROM t_visu");
			resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				int codigo = resultSet.getInt("cd_visualizacao");
				int codigo_usuario = resultSet.getInt("cd_login");
				int codigo_video = resultSet.getInt("cd_cod_video");
				Date data = resultSet.getDate("dt_data");
				
				Visualizacao visualizacao = new Visualizacao(codigo, codigo_usuario, codigo_video, data);
				lista.add(visualizacao);
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
