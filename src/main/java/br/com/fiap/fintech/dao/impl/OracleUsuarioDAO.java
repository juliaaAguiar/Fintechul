package br.com.fiap.fintech.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.fintech.bean.Usuario;
import br.com.fiap.fintech.dao.PessoaDAO;
import br.com.fiap.fintech.dao.UsuarioDAO;
import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.factory.DAOFactory;
import br.com.fiap.fintech.singleton.ConnectionManager;
public class OracleUsuarioDAO implements UsuarioDAO {
	private Connection conexao;

	@Override
	public void atualizar(Usuario usuario) throws DBException {
		PreparedStatement statement = null;
		try {
			PessoaDAO pessoadao = DAOFactory.getPessoaDAO();
			pessoadao.atualizar(usuario);
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE t_login SET nm_email = ?, nm_senha = ?,  nr_telefone= ?, tp_perfil = ? WHERE cd_login = ?";
			statement = conexao.prepareStatement(sql);
			statement.setNString(1, usuario.getEmail());
			statement.setNString(2, usuario.getSenha());
			statement.setNString(3, usuario.getTelefone());
			statement.setNString(4, usuario.getPerfil());
			statement.setInt(5, usuario.getCodigo());
			
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("Erro ao atualizar usuario. ");
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
	public void cadastrar(Usuario usuario) throws DBException {
		PreparedStatement statement = null;
		try {
			System.out.println(usuario.getPessoa().getCodigo());
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO t_login(cd_login, nm_senha, nm_email, nr_telefone, tp_perfil, cd_pessoa) VALUES (sq_usuario.nextval, ?, ?, ?, ?, ?)";
			statement = conexao.prepareStatement(sql);
			statement.setNString(1, usuario.getSenha());
			statement.setNString(2, usuario.getEmail());
			statement.setNString(3, usuario.getTelefone());
			statement.setNString(4, usuario.getPerfil());
			statement.setInt(5, usuario.getCodigoPessoa());
			
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("Erro ao cadastrar usuario. ");
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
			String sql = "DELETE FROM t_login WHERE cd_login = ?";
			statement = conexao.prepareStatement(sql);
			statement.setInt(1, codigo);
			
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("Erro ao excluir usuario. ");
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
	public Usuario buscar(int id) {
		Usuario usuario = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			statement = conexao.prepareStatement("SELECT * FROM t_login WHERE cd_login = ?");
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			
			if (resultSet.next()) {
				int codigo = resultSet.getInt("cd_login");
				int codigo_pessoa = resultSet.getInt("cd_pessoa");
				String email = resultSet.getNString("nm_email");
				String senha = resultSet.getNString("nm_senha");
				String perfil = resultSet.getNString("tp_perfil");
				String telefone = resultSet.getNString("nr_telefone");
				
				usuario = new Usuario(codigo, codigo_pessoa, email, senha, telefone, perfil);
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
		return usuario;
	}

	@Override
	public List<Usuario> listar() {
		List<Usuario> lista = new ArrayList<Usuario>();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			statement = conexao.prepareStatement("SELECT * FROM t_login");
			resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				int codigo = resultSet.getInt("cd_login");
				int codigo_pessoa = resultSet.getInt("cd_pessoa");
				String email = resultSet.getNString("nm_email");
				String senha = resultSet.getNString("nm_senha");
				String perfil = resultSet.getNString("tp_perfil");
				String telefone = resultSet.getNString("nr_telefone");
				
				Usuario usuario  = new Usuario(codigo, codigo_pessoa, email, senha, telefone, perfil);
				lista.add(usuario);
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
