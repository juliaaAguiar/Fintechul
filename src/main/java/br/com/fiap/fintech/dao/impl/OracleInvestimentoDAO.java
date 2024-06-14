package br.com.fiap.fintech.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.fintech.bean.Investimento;
import br.com.fiap.fintech.dao.InvestimentoDAO;
import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.singleton.ConnectionManager;

public class OracleInvestimentoDAO implements InvestimentoDAO {
	private Connection conexao;

	@Override
	public void atualizar(Investimento investimento) throws DBException {
		PreparedStatement statement = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE t_invest SET qt_quantidade = ? WHERE cd_ativo = ? and cd_carteira = ?";
			statement = conexao.prepareStatement(sql);
			statement.setInt(1, investimento.getAtivo().getCodigo());
			statement.setDouble(2, investimento.getCarteiraInvestimento().getCodigo());
			
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("Erro ao atualizar investimento. ");
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
	public void cadastrar(Investimento investimento) throws DBException {
		PreparedStatement statement = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO t_invest (cd_ativo, cd_carteira, dt_aquisicao, qt_quantidade) VALUES (?, ?, ?, ?)";
			statement = conexao.prepareStatement(sql);
			statement.setInt(1, investimento.getAtivo().getCodigo());
			statement.setInt(2, investimento.getCarteiraInvestimento().getCodigo());
			statement.setDate(3, investimento.getData());
			statement.setInt(4, investimento.getQuantidade());
			
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("Erro ao cadastrar investimento. ");
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
	public void remover(Investimento investimento) throws DBException {
		PreparedStatement statement = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "DELETE FROM t_invest WHERE cd_ativo = ? and cd_carteira = ?";
			statement = conexao.prepareStatement(sql);
			statement.setInt(1, investimento.getAtivo().getCodigo());
			statement.setDouble(2, investimento.getCarteiraInvestimento().getCodigo());
			
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("Erro ao excluir investimento. ");
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
	public Investimento buscar(int cd_ativo, int cd_carteira) {
		Investimento investimento = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			statement = conexao.prepareStatement("SELECT * FROM t_invest WHERE cd_ativo = ? and cd_carteira = ?");
			statement.setInt(1, cd_ativo);
			statement.setDouble(2, cd_carteira);
			resultSet = statement.executeQuery();
			
			if (resultSet.next()) {
				int codigo_ativo = resultSet.getInt("cd_ativo");
				int codigo_carteira = resultSet.getInt("cd_carteira");
				int quantidade = resultSet.getInt("qt_quantidade");
				
				investimento = new Investimento(codigo_ativo, codigo_carteira, quantidade);
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
		return investimento;
	}

	@Override
	public List<Investimento> listar() {
		List<Investimento> lista = new ArrayList<Investimento>();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			statement = conexao.prepareStatement("SELECT * FROM t_invest");
			resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				int codigo_ativo = resultSet.getInt("cd_ativo");
				int codigo_carteira = resultSet.getInt("cd_carteira");
				int quantidade = resultSet.getInt("qt_quantidade");
				
				Investimento investimento = new Investimento(codigo_ativo, codigo_carteira, quantidade);
				lista.add(investimento);
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
