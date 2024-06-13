package br.com.fiap.fintech.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.fintech.bean.Cartao;
import br.com.fiap.fintech.dao.CartaoDAO;
import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.singleton.ConnectionManager;

public class OracleCartaoDAO implements CartaoDAO {
	private Connection conexao;

	@Override
	public void atualizar(Cartao cartao) throws DBException {	
		PreparedStatement statement = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE t_cartao SET tp_status = ?, nr_numero = ?, tp_virtual = ? WHERE cd_cartao = ?";
			statement = conexao.prepareStatement(sql);
			statement.setNString(1, cartao.getStatus());
			statement.setLong(2, cartao.getNumero());
			statement.setInt(3, cartao.getIsVirtual());
			statement.setInt(4, cartao.getCodigo());
			
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("Erro ao atualizar cartao. ");
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
		ResultSet resultSet = null;
		int cartaoId = -1;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO t_cartao (cd_cartao, tp_status, tp_virtual, tp_cartao, nr_numero, cd_conta) VALUES (sq_cartao.nextval, ?, ?, ?, ?, ?)";
			String[] generatedColumns = {"cd_cartao"};
			statement = conexao.prepareStatement(sql, generatedColumns);
			statement.setNString(1, cartao.getStatus());
			statement.setInt(2, cartao.getIsVirtual());
			statement.setNString(3, cartao.getTipo());
			statement.setLong(4, cartao.getNumero());
			statement.setInt(5, cartao.getConta().getCodigo());
			
			statement.executeUpdate();
			resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                cartaoId = resultSet.getInt(1);
            }
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("Erro ao cadastrar cartao. ");
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cartaoId;
	}

	@Override
	public void remover(int codigo) throws DBException {
		PreparedStatement statement = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "DELETE FROM t_cartao WHERE cd_cartao = ?";
			statement = conexao.prepareStatement(sql);
			statement.setInt(1, codigo);
			
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("Erro ao excluir cartao. ");
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
		Cartao cartao = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			statement = conexao.prepareStatement("SELECT * FROM t_cartao WHERE cd_cartao = ?");
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			
			if (resultSet.next()) {
				int codigo = resultSet.getInt("cd_cartao");
				int codigo_conta = resultSet.getInt("cd_conta");
				int numero = resultSet.getInt("nm_numero");
				String tipo_cartao = resultSet.getNString("tp_cartao");
				int virtual = resultSet.getInt("tp_virtual");
				
				cartao = new Cartao(codigo, codigo_conta, numero, tipo_cartao, virtual);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				resultSet.close();
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
			statement = conexao.prepareStatement("SELECT * FROM t_cartao");
			resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				int codigo = resultSet.getInt("cd_cartao");
				int codigo_conta = resultSet.getInt("cd_conta");
				int numero = resultSet.getInt("nm_numero");
				String tipo_cartao = resultSet.getNString("tp_cartao");
				int virtual = resultSet.getInt("tp_virtual");
				
				Cartao cartao = new Cartao(codigo, codigo_conta, numero, tipo_cartao, virtual);
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
