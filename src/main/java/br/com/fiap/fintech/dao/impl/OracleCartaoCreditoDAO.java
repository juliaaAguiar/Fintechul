package br.com.fiap.fintech.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.fintech.bean.Cartao;
import br.com.fiap.fintech.bean.CartaoCredito;
import br.com.fiap.fintech.dao.CartaoDAO;
import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.singleton.ConnectionManager;

public class OracleCartaoCreditoDAO extends OracleCartaoDAO implements CartaoDAO {
	private Connection conexao;

	@Override
	public void atualizar(Cartao cartao) throws DBException {
		super.atualizar(cartao);
		PreparedStatement statement = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE t_credito SET nr_limite = ?, dt_vencimento = ? WHERE cd_cartaocredito = ?";
			statement = conexao.prepareStatement(sql);
			statement.setDouble(1, ((CartaoCredito) cartao).getLimite());
            statement.setInt(2, ((CartaoCredito) cartao).getDiaVencimentoFatura());
            statement.setInt(3, cartao.getCodigo());
			
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("Erro ao atualizar cartao de credito. ");
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
			String sql = "INSERT INTO t_credito (cd_cartao, nr_limite, dt_vencimento) VALUES (?, ?, ?)";
			statement = conexao.prepareStatement(sql);
			statement.setInt(1, cartaoId);
			statement.setDouble(2, ((CartaoCredito) cartao).getLimite());
			statement.setInt(3, ((CartaoCredito) cartao).getDiaVencimentoFatura());
			
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("Erro ao cadastrar cartao de credito. ");
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
			String sql = "DELETE FROM t_credito WHERE cd_cartao = ?";
			statement = conexao.prepareStatement(sql);
			statement.setInt(1, codigo);
			
			statement.executeUpdate();
			super.remover(codigo);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("Erro ao excluir cartao de credito. ");
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
		CartaoCredito cartao = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			statement = conexao.prepareStatement("SELECT * FROM t_credito WHERE cd_cartao = ?");
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			
			if (resultSet.next()) {
				int codigo = resultSet.getInt("cd_cartao");
				int data_vencimento = resultSet.getInt("dt_vencimento");
				double limite = resultSet.getDouble("nr_limite");
				
				cartao = new CartaoCredito(codigo, data_vencimento, limite);
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
		List<Cartao> lista = new ArrayList<>();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			statement = conexao.prepareStatement("SELECT * FROM t_credito");
			resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				int codigo = resultSet.getInt("cd_cartao");
				int data_vencimento = resultSet.getInt("dt_vencimento");
				double limite = resultSet.getDouble("nr_limite");
				
				CartaoCredito cartao = new CartaoCredito(codigo, data_vencimento, limite);
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