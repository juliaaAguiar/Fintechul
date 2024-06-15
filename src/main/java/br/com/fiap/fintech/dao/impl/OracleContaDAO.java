package br.com.fiap.fintech.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.fintech.bean.Conta;
import br.com.fiap.fintech.bean.Deposito;
import br.com.fiap.fintech.bean.Despesa;
import br.com.fiap.fintech.bean.Extrato;
import br.com.fiap.fintech.bean.Usuario;
import br.com.fiap.fintech.dao.ContaDAO;
import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.singleton.ConnectionManager;
import java.sql.Date;

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
				int codigo_usuario = resultSet.getInt("cd_login");
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

	public Extrato extrato(Conta conta, Usuario usuario)
	{
		List<Deposito> depositos = new ArrayList<Deposito>();
		List<Despesa> despesas = new ArrayList<Despesa>();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "WITH despesa AS (     SELECT vl_gasto, dt_despesa, cd_cartao     FROM t_despesa ), deposito AS (     SELECT cd_deposito, cd_conta, dt_deposito, vl_deposito     FROM t_deposito ) SELECT      despesa.vl_gasto,      despesa.dt_despesa,     deposito.vl_deposito,     deposito.dt_deposito FROM      cartao     INNER JOIN conta ON conta.cd_conta = cartao.cd_conta     INNER JOIN usuario ON usuario.cd_login = conta.cd_login     INNER JOIN despesa ON cartao.cd_cartao = despesa.cd_cartao     INNER JOIN deposito ON deposito.cd_conta = conta.cd_conta WHERE      conta.cd_conta = ?      AND usuario.cd_login = ?     AND despesa.dt_despesa = deposito.dt_deposito;";
			statement = conexao.prepareStatement(sql);
			resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				double vl_gasto = resultSet.getDouble("despesa.vl_gasto");
				Date data_despesa = resultSet.getDate("despesa.dt_despesa");
				double vl_deposito = resultSet.getDouble("deposito.vl_deposito");
				double dt_deposito = resultSet.getDouble("deposito.dt_deposito");

				Deposito deposito = new Deposito(dt_deposito, vl_deposito);
				Despesa despesa = new Despesa(data_despesa, vl_gasto);
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
	}
}
