package br.com.fiap.fintech.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.fintech.bean.CarteiraInvestimento;
import br.com.fiap.fintech.dao.CarteiraInvestimentoDAO;
import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.singleton.ConnectionManager;

public class OracleCarteiraInvestimentoDAO implements CarteiraInvestimentoDAO {
	private Connection conexao;
	
	@Override
	public void atualizar(CarteiraInvestimento carteira) throws DBException {
		PreparedStatement statement = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE t_carteira SET nm_nome = ?, nr_quantidadeativos = ?, nr_totalinvestimento = ? WHERE cd_carteira = ?";
			statement = conexao.prepareStatement(sql);
			statement.setNString(1, carteira.getNome());
			statement.setInt(2, carteira.getQuantidadeAtivos());
			statement.setDouble(3, carteira.getTotalInvestido());
			statement.setInt(4, carteira.getConta().getCodigo());
			
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("Erro ao atualizar carteira. ");
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
	public void cadastrar(CarteiraInvestimento carteira) throws DBException {	
		PreparedStatement statement = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO t_carteira (cd_carteira, cd_conta, nm_nome, nr_quantidadeativos, nr_totalinvestido) VALUES (sq_carteira.nextval, ?, ?, ?, ?)";
			statement = conexao.prepareStatement(sql);
			statement.setInt(1, carteira.getConta().getCodigo());
			statement.setNString(2, carteira.getNome());
			statement.setInt(3, carteira.getQuantidadeAtivos());
			statement.setDouble(4, carteira.getTotalInvestido());
			
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("Erro ao criar carteira de investimentos. ");
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
			String sql = "DELETE FROM t_carteira WHERE cd_carteira = ?";
			statement = conexao.prepareStatement(sql);
			statement.setInt(1, codigo);
			
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("Erro ao excluir carteira de investimentos. ");
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
	public CarteiraInvestimento buscar(int id) {
		CarteiraInvestimento carteira = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			statement = conexao.prepareStatement("SELECT * FROM t_carteira WHERE cd_carteira = ?");
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			
			if (resultSet.next()) {
				int codigo = resultSet.getInt("cd_carteira");
				String nome = resultSet.getNString("nm_nome");
				int quantidadeAtivos = resultSet.getInt("nr_quantidadeAtivos");
				double totalInvestido = resultSet.getInt("nr_totalInvestido");
				
				carteira = new CarteiraInvestimento(codigo, nome, quantidadeAtivos, totalInvestido);
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
		return carteira;
	}

	@Override
	public List<CarteiraInvestimento> listar() {
		List<CarteiraInvestimento> lista = new ArrayList<CarteiraInvestimento>();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			statement = conexao.prepareStatement("SELECT * FROM t_carteira");
			resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				int codigo = resultSet.getInt("cd_carteira");
				String nome = resultSet.getNString("nm_nome");
				int quantidadeAtivos = resultSet.getInt("nr_quantidadeAtivos");
				double totalInvestido = resultSet.getInt("nr_totalInvestido");
				
				CarteiraInvestimento  carteira = new CarteiraInvestimento(codigo, nome, quantidadeAtivos, totalInvestido);
				lista.add(carteira);
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
