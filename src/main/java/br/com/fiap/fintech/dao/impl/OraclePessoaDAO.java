package br.com.fiap.fintech.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.fintech.bean.Pessoa;
import br.com.fiap.fintech.dao.PessoaDAO;
import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.singleton.ConnectionManager;

public class OraclePessoaDAO implements PessoaDAO {
	private Connection conexao;

	@Override
	public void atualizar(Pessoa pessoa) throws DBException {
		PreparedStatement statement = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "Update t_pessoa SET nm_nome = ?, tp_status = ? WHERE cd_pessoa = ?";
			statement = conexao.prepareStatement(sql);
			statement.setNString(1, pessoa.getNome());
			statement.setNString(2, pessoa.getStatus());
			statement.setInt(3, pessoa.getCodigo());
			
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("Erro ao atualizar pessoa. ");
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
	public int cadastrar(Pessoa pessoa) throws DBException {
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		int pessoaId = -1;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO t_pessoa(cd_pessoa, cd_cpf, nm_nome, tp_status) VALUES (SQ_PESSOA.nextval, ?, ?, ?)";
			String[] generatedColumns = {"cd_pessoa"};
			statement = conexao.prepareStatement(sql, generatedColumns);
			statement.setNString(1, pessoa.getCpf());
			statement.setNString(2, pessoa.getNome());
			statement.setNString(3, pessoa.getStatus());
			
			statement.executeUpdate();
			resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
            	pessoaId = resultSet.getInt(1);
            }
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("Erro ao cadastrar pessoa. ");
		} finally {
			try {
				statement.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return pessoaId;
	}

	@Override
	public void remover(int codigo) throws DBException {
		PreparedStatement statement = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "DELETE FROM t_pessoa WHERE cd_pessoa = ?";
			statement = conexao.prepareStatement(sql);
			statement.setInt(1, codigo);
			
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("Erro ao excluir pessoa. ");
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
	public Pessoa buscar(int id) {
		Pessoa pessoa = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			statement = conexao.prepareStatement("SELECT * FROM t_pessoa WHERE cd_pessoa = ?");
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			
			if (resultSet.next()) {
				int codigo = resultSet.getInt("cd_pessoa");
				String cpf = resultSet.getNString("cd_cpf");
				String nome = resultSet.getNString("nm_nome");
				String status = resultSet.getNString("tp_status");
				
				pessoa = new Pessoa(codigo, nome, cpf, status);
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
		return pessoa;
	}

	@Override
	public List<Pessoa> listar() {
		List<Pessoa> lista = new ArrayList<Pessoa>();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			statement = conexao.prepareStatement("SELECT * FROM t_pessoa");
			resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				int codigo = resultSet.getInt("cd_pessoa");
				String cpf = resultSet.getNString("cd_cpf");
				String nome = resultSet.getNString("nm_nome");
				String status = resultSet.getNString("tp_status");
				
				Pessoa pessoa = new Pessoa(codigo, nome, cpf, status);
				lista.add(pessoa);
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
