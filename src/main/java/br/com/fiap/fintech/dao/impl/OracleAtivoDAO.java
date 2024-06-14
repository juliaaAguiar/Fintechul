package br.com.fiap.fintech.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.fintech.bean.Ativo;
import br.com.fiap.fintech.dao.AtivoDAO;
import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.singleton.ConnectionManager;

public class OracleAtivoDAO implements AtivoDAO {
	private Connection conexao;

	@Override
	public void atualizar(Ativo ativo) throws DBException {	
		PreparedStatement statement = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE t_ativo SET ds_tipo = ?, nm_ativo = ?, vl_atual = ?, ds_descricao = ? WHERE cd_ativo = ?";
			statement = conexao.prepareStatement(sql);
			statement.setNString(1, ativo.getTipo());
			statement.setNString(2, ativo.getNome());
			statement.setDouble(3, ativo.getValorAtual());
			statement.setNString(4, ativo.getDescricao());
			statement.setInt(5, ativo.getCodigo());
			
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("Erro ao atualizar ativo. ");
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
	public void cadastrar(Ativo ativo) throws DBException {	
		PreparedStatement statement = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO t_ativo(cd_ativo, ds_tipo, nm_ativo, vl_atual, ds_descricao) VALUES (sq_ativo.nextval, ?, ?, ?, ?)";
			statement = conexao.prepareStatement(sql);
			statement.setNString(1, ativo.getTipo());
			statement.setNString(2, ativo.getNome());
			statement.setDouble(3, ativo.getValorAtual());
			statement.setNString(4, ativo.getDescricao());
			
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("Erro ao cadastrar ativo. ");
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
			String sql = "DELETE FROM t_ativo WHERE cd_ativo = ?";
			statement = conexao.prepareStatement(sql);
			statement.setInt(1, codigo);
			
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("Erro ao excluir ativo. ");
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
	public Ativo buscar(int id) {
		Ativo ativo = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			statement = conexao.prepareStatement("SELECT * FROM t_ativo WHERE cd_ativo = ?");
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			
			if (resultSet.next()) {
				int codigo = resultSet.getInt("cd_ativo");
				String descricao = resultSet.getNString("ds_descricao");
				String nome  = resultSet.getNString("nm_ativo");
				String tipo_ativo  = resultSet.getNString("ds_tipo");
				double valor_atual = resultSet.getDouble("vl_atual");
				
				ativo = new Ativo(codigo, descricao, nome, tipo_ativo, valor_atual);
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
		return ativo;
	}

	@Override
	public List<Ativo> listar() {
		List<Ativo> lista = new ArrayList<Ativo>();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			statement = conexao.prepareStatement("SELECT * FROM t_ativo");
			resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				int codigo = resultSet.getInt("cd_ativo");
				String descricao = resultSet.getNString("ds_descricao");
				String nome  = resultSet.getNString("nm_ativo");
				String tipo_ativo  = resultSet.getNString("ds_tipo");
				double valor_atual = resultSet.getDouble("vl_atual");
				
				Ativo ativo = new Ativo(codigo, descricao, nome, tipo_ativo, valor_atual);
				lista.add(ativo);
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
