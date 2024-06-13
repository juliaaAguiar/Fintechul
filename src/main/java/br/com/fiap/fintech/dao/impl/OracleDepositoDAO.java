package br.com.fiap.fintech.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.fintech.bean.Deposito;
import br.com.fiap.fintech.dao.DepositoDAO;
import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.singleton.ConnectionManager;

public class OracleDepositoDAO implements DepositoDAO {
	private Connection conexao;

	@Override
	public void atualizar(Deposito deposito) throws DBException {
		PreparedStatement statement = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE t_deposito SET dt_deposito = ?, vl_deposito = ? WHERE cd_deposito = ?";
			statement = conexao.prepareStatement(sql);
			statement.setDate(1, deposito.getData());
			statement.setDouble(2, deposito.getValor());
			statement.setInt(3, deposito.getCodigo());
			
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("Erro ao atualizar deposito. ");
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
	public void cadastrar(Deposito deposito) throws DBException {
		PreparedStatement statement = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO t_deposito (cd_deposito, cd_conta, dt_deposito, vl_deposito) VALUES (sq_deposito.nextval, ?, ?, ?)";
			statement = conexao.prepareStatement(sql);
			statement.setInt(1, deposito.getConta().getCodigo());
			statement.setDate(2, deposito.getData());
			statement.setDouble(3, deposito.getValor());
			
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("Erro ao cadastrar deposito. ");
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
			String sql = "DELETE FROM t_deposito WHERE cd_deposito = ?";
			statement = conexao.prepareStatement(sql);
			statement.setInt(1, codigo);
			
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("Erro ao excluir deposito. ");
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
	public Deposito buscar(int id) {
		Deposito deposito = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			statement = conexao.prepareStatement("SELECT * FROM t_deposito WHERE cd_deposito = ?");
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			
			if (resultSet.next()) {
				int codigo = resultSet.getInt("cd_conta");
				int codigo_conta = resultSet.getInt("cd_login");
				Date data = resultSet.getDate("dt_deposito");
				double valor = resultSet.getInt("vl_deposito");
				
				deposito = new Deposito(codigo, data, valor);
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
		return deposito;
	}

	@Override
	public List<Deposito> listar() {
		List<Deposito> lista = new ArrayList<Deposito>();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			statement = conexao.prepareStatement("SELECT * FROM t_deposito");
			resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				int codigo = resultSet.getInt("cd_conta");
				Date data = resultSet.getDate("dt_deposito");
				double valor = resultSet.getInt("vl_deposito");
				
				Deposito deposito = new Deposito(codigo, data, valor);
				lista.add(deposito);
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
