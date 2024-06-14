package br.com.fiap.fintech.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.fintech.bean.PagamentoRecorrente;
import br.com.fiap.fintech.dao.PagamentoRecorrenteDAO;
import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.singleton.ConnectionManager;

public class OraclePagamentoRecorrenteDAO implements PagamentoRecorrenteDAO {
	private Connection conexao;

	@Override
	public void atualizar(PagamentoRecorrente pagamento) throws DBException {
		PreparedStatement statement = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE t_despesa SET nm_nome = ?, nr_valor = ?, dt_data = ? WHERE cd_pagamentoRecorrente = ?";
			statement = conexao.prepareStatement(sql);
			statement.setNString(1, pagamento.getNome());
			statement.setDouble(2, pagamento.getValor());
			statement.setDate(3, pagamento.getData());
			statement.setInt(4, pagamento.getCodigo());
			
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("Erro ao atualizar pagamento recorrente. ");
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
	public void cadastrar(PagamentoRecorrente pagamento) throws DBException {
		PreparedStatement statement = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO t_pag_rec (cd_pagamentoRecorrente, cd_conta, nm_nome, nr_valor, dt_data) VALUES (sq_pagamentorecorrente.nextval, ?, ?, ?, ?)";
			statement = conexao.prepareStatement(sql);
			statement.setInt(1, pagamento.getConta().getCodigo());
			statement.setNString(2, pagamento.getNome());
			statement.setDouble(3, pagamento.getValor());
			statement.setDate(4, pagamento.getData());
			
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("Erro ao criar pagamento recorrente. ");
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
			String sql = "DELETE FROM t_pag_rec WHERE cd_pagamentoRecorrente = ?";
			statement = conexao.prepareStatement(sql);
			statement.setInt(1, codigo);
			
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("Erro ao excluir pagamento recorrente. ");
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
	public PagamentoRecorrente buscar(int id) {
		PagamentoRecorrente pagamento = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			statement = conexao.prepareStatement("SELECT * FROM t_pag_rec WHERE cd_pagamentoRecorrente = ?");
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			
			if (resultSet.next()) {
				int codigo = resultSet.getInt("cd_pagamentoRecorrente");
				int codigo_conta = resultSet.getInt("cd_conta");
				Date data = resultSet.getDate("dt_data");
				String nome = resultSet.getNString("nm_nome");
				double valor = resultSet.getDouble("nr_valor");
				
				pagamento = new PagamentoRecorrente(codigo, data, nome, valor);
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
		return pagamento;
	}

	@Override
	public List<PagamentoRecorrente> listar() {
		List<PagamentoRecorrente> lista = new ArrayList<PagamentoRecorrente>();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			statement = conexao.prepareStatement("SELECT * FROM t_pag_rec");
			resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				int codigo = resultSet.getInt("cd_pagamentoRecorrente");
				int codigo_conta = resultSet.getInt("cd_conta");
				Date data = resultSet.getDate("dt_data");
				String nome = resultSet.getNString("nm_nome");
				double valor = resultSet.getDouble("nr_valor");
				
				PagamentoRecorrente pagamento = new PagamentoRecorrente(codigo, data, nome, valor);
				lista.add(pagamento);
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
