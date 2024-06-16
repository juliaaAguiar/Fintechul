package br.com.fiap.fintech.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.fintech.bean.Conta;
import br.com.fiap.fintech.bean.Transacao;
import br.com.fiap.fintech.dao.ContaDAO;
import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.singleton.ConnectionManager;

public class OracleContaDAO implements ContaDAO {
	private Connection conexao;

	@Override
	public void atualizar(Conta conta) throws DBException {	
		PreparedStatement statement = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE t_conta SET nr_agencia = ?, nr_numero = ?, nr_saldo = ?, ds_tipo = ? WHERE cd_conta = ?";
			statement = conexao.prepareStatement(sql);
			statement.setInt(1, conta.getAgencia());
			statement.setInt(2, conta.getNumero());
			statement.setDouble(3, conta.getSaldo());
			statement.setNString(4, conta.getTipo());
			statement.setInt(5, conta.getCodigo());
			
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("Erro ao atualizar conta. ");
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
	public void cadastrar(Conta conta) throws DBException {	
		PreparedStatement statement = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO t_conta (cd_conta, nr_agencia, nr_numero, nr_saldo, ds_tipo, cd_login) VALUES (sq_conta.nextval, ?, ?, ?, ?, ?)";
			statement = conexao.prepareStatement(sql);
			statement.setInt(1, conta.getAgencia());
			statement.setInt(2, conta.getNumero());
			statement.setDouble(3, conta.getSaldo());
			statement.setNString(4, conta.getTipo());
			statement.setInt(5, conta.getUsuario().getCodigo());
			
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("Erro ao cadastrar conta. ");
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
			String sql = "DELETE FROM t_conta WHERE cd_conta = ?";
			statement = conexao.prepareStatement(sql);
			statement.setInt(1, codigo);
			
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("Erro ao excluir conta. ");
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
	public Conta buscar(int id) {
		Conta conta = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			statement = conexao.prepareStatement("SELECT * FROM t_conta WHERE cd_conta = ?");
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			
			if (resultSet.next()) {
				int agencia = resultSet.getInt("nr_agencia");
				int codigo = resultSet.getInt("cd_conta");
				int numero = resultSet.getInt("nr_numero");
				double saldo = resultSet.getDouble("nr_saldo");
				String tipo = resultSet.getNString("ds_tipo");
				
				conta = new Conta(agencia, codigo, numero, saldo, tipo);
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
		return conta;
	}

	@Override
	public List<Conta> listar() {
		List<Conta> lista = new ArrayList<Conta>();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			statement = conexao.prepareStatement("SELECT * FROM t_conta");
			resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				int agencia = resultSet.getInt("nr_agencia");
				int codigo = resultSet.getInt("cd_conta");
				int numero = resultSet.getInt("nr_numero");
				double saldo = resultSet.getDouble("nr_saldo");
				String tipo = resultSet.getNString("ds_tipo");
				
				Conta conta = new Conta(agencia, codigo, numero, saldo, tipo);
				lista.add(conta);
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
	
	@Override
	public List<Transacao> extrato(int contaId) {
	    List<Transacao> transacoes = new ArrayList<>();
	    String sql = "SELECT 'DEPOSITO' AS tipo, dt_deposito AS data, vl_deposito AS valor FROM T_DEPOSITO WHERE cd_conta = ? " +
	                 "UNION ALL " +
	                 "SELECT 'DESPESA' AS tipo, dt_despesa AS data, vl_gasto AS valor FROM T_DESPESA WHERE cd_conta = ? " +
	                 "ORDER BY data";

	    try (Connection conexao = ConnectionManager.getInstance().getConnection();
	         PreparedStatement statement = conexao.prepareStatement(sql)) {

	        statement.setInt(1, contaId);
	        statement.setInt(2, contaId);
	        try (ResultSet resultSet = statement.executeQuery()) {
	            while (resultSet.next()) {
	                Transacao transacao = new Transacao();
	                transacao.setTipo(resultSet.getString("tipo"));
	                transacao.setData(resultSet.getDate("data"));
	                transacao.setValor(resultSet.getDouble("valor"));
	                transacoes.add(transacao);
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } 
	    return transacoes;
	}

}
