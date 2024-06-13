package br.com.fiap.fintech.factory;

import br.com.fiap.fintech.dao.AtivoDAO;
import br.com.fiap.fintech.dao.CartaoDAO;
import br.com.fiap.fintech.dao.CarteiraInvestimentoDAO;
import br.com.fiap.fintech.dao.ContaDAO;
import br.com.fiap.fintech.dao.DepositoDAO;
import br.com.fiap.fintech.dao.DespesaDAO;
import br.com.fiap.fintech.dao.InvestimentoDAO;
import br.com.fiap.fintech.dao.PagamentoRecorrenteDAO;
import br.com.fiap.fintech.dao.PessoaDAO;
import br.com.fiap.fintech.dao.UsuarioDAO;
import br.com.fiap.fintech.dao.VideoDAO;
import br.com.fiap.fintech.dao.VisualizacaoDAO;
import br.com.fiap.fintech.dao.impl.OracleAtivoDAO;
import br.com.fiap.fintech.dao.impl.OracleCartaoCreditoDAO;
import br.com.fiap.fintech.dao.impl.OracleCartaoDAO;
import br.com.fiap.fintech.dao.impl.OracleCartaoDebitoDAO;
import br.com.fiap.fintech.dao.impl.OracleCarteiraInvestimentoDAO;
import br.com.fiap.fintech.dao.impl.OracleContaDAO;
import br.com.fiap.fintech.dao.impl.OracleDepositoDAO;
import br.com.fiap.fintech.dao.impl.OracleDespesaDAO;
import br.com.fiap.fintech.dao.impl.OracleInvestimentoDAO;
import br.com.fiap.fintech.dao.impl.OraclePagamentoRecorrenteDAO;
import br.com.fiap.fintech.dao.impl.OraclePessoaDAO;
import br.com.fiap.fintech.dao.impl.OracleUsuarioDAO;
import br.com.fiap.fintech.dao.impl.OracleVideoDAO;
import br.com.fiap.fintech.dao.impl.OracleVisualizacaoDAO;

public class DAOFactory {
	public static AtivoDAO getAtivoDAO() {
		return new OracleAtivoDAO();
	}
	
	public static PessoaDAO getUsuarioDAO() {
		return new OracleUsuarioDAO();
	}
	
	public static PessoaDAO getPessoaDAO() {
		return new OraclePessoaDAO();
	}
	
	public static CartaoDAO getCartaoDAO() {
		return new OracleCartaoDAO();
	}
	
	public static CartaoDAO getCartaoCreditoDAO() {
		return new OracleCartaoCreditoDAO();
	}
	
	public static CartaoDAO getCartaoDebitoDAO() {
		return new OracleCartaoDebitoDAO();
	}
	
	public static CarteiraInvestimentoDAO getCarteiraInvestimentoDAO() {
		return new OracleCarteiraInvestimentoDAO();
	}
	
	public static ContaDAO getContaDAO() {
		return new OracleContaDAO();
	}
	
	public static DepositoDAO getDepositoDAO() {
		return new OracleDepositoDAO();
	}
	
	public static DespesaDAO getDespesaDAO() {
		return new OracleDespesaDAO();
	}
	
	public static InvestimentoDAO getInvestimentoDAO() {
		return new OracleInvestimentoDAO();
	}
	
	public static PagamentoRecorrenteDAO getPagamentoRecorrenteDAO() {
		return new OraclePagamentoRecorrenteDAO();
	}
	
	public static VideoDAO getVideoDAO() {
		return new OracleVideoDAO();
	}
	
	public static VisualizacaoDAO getVisualizacaoDAO() {
		return new OracleVisualizacaoDAO();
	}
}
