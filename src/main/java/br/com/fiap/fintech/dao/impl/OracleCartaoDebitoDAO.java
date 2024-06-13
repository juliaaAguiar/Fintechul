package br.com.fiap.fintech.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.fintech.bean.Cartao;
import br.com.fiap.fintech.bean.CartaoDebito;
import br.com.fiap.fintech.dao.CartaoDAO;
import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.singleton.ConnectionManager;

public class OracleCartaoDebitoDAO extends OracleCartaoDAO implements CartaoDAO {
	private Connection conexao;

	@Override
	public void atualizar(Cartao cartao) throws DBException {
		super.atualizar(cartao);
		PreparedStatement statement = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE t_debito SET vl_saldo = ? WHERE cd_cartao = ?";
			statement = conexao.prepareStatement(sql);
			statement.setDouble(1, ((CartaoDebito) cartao).getSaldo());
			statement.setInt(2, cartao.getCodigo());
			
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("Erro ao atualizar cartao de debito. ");
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
	public int cadastrar(Cartao cartao) throws DBException {
		PreparedStatement statement = null;
		int cartaoId;
		try {
			cartaoId = super.cadastrar(cartao);
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO t_debito (cd_cartao, vl_saldo) VALUES (?, ?)";
			statement = conexao.prepareStatement(sql);
			statement.setInt(1, cartaoId);
			statement.setDouble(2, ((CartaoDebito) cartao).getSaldo());
			
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("Erro ao cadastrar cartao de debito. ");
		} finally {
			try {
				statement.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public void remover(int codigo) throws DBException {
		PreparedStatement statement = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "DELETE FROM t_debito WHERE cd_cartao = ?";
			statement = conexao.prepareStatement(sql);
			statement.setInt(1, codigo);
			
			statement.executeUpdate();
			super.remover(codigo);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("Erro ao excluir cartao de debito. ");
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
	public Cartao buscar(int id) {
		CartaoDebito cartao = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			statement = conexao.prepareStatement("SELECT * FROM t_debito WHERE cd_cartao = ?");
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			
			if (resultSet.next()) {
				int codigo = resultSet.getInt("cd_cartao");
				double saldo = resultSet.getInt("vl_saldo");
				
				cartao = new CartaoDebito(codigo, saldo);
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
		return cartao;
	}
	
	@Override
	public List<Cartao> listar() {
		List<Cartao> lista = new ArrayList<Cartao>();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			statement = conexao.prepareStatement("SELECT * FROM t_debito");
			resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				int codigo = resultSet.getInt("cd_cartao");
				double saldo = resultSet.getDouble("vl_saldo");
				
				CartaoDebito cartao = new CartaoDebito(codigo, saldo);
				lista.add(cartao);
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
