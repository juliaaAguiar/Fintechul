package br.com.fiap.fintech.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.fintech.bean.Transacao;
import br.com.fiap.fintech.singleton.ConnectionManager;

@WebServlet("/extrato")
public class ExtratoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Connection conexao;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String contaId = request.getParameter("contaId");
        PreparedStatement statement = null;
        List<Transacao> transacoes = new ArrayList<>();

        try {
        	conexao = ConnectionManager.getInstance().getConnection();
            String sql = "SELECT 'DEPOSITO' AS tipo, d.dt_deposito AS data, d.vl_deposito AS valor FROM T_DEPOSITO d WHERE d.cd_conta = ? " +
                    "UNION ALL " +
                    "SELECT 'DESPESA' AS tipo, de.dt_despesa AS data, de.vl_gasto AS valor FROM T_DESPESA de JOIN T_CARTAO c ON de.cd_cartao = c.cd_cartao WHERE c.cd_conta = ? " +
                    "ORDER BY data";
            statement = conexao.prepareStatement(sql);
            statement.setInt(1, Integer.parseInt(contaId));
            statement.setInt(2, Integer.parseInt(contaId));
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Transacao transacao = new Transacao();
                transacao.setTipo(resultSet.getString("tipo"));
                transacao.setData(resultSet.getDate("data"));
                transacao.setValor(resultSet.getDouble("valor"));
                transacoes.add(transacao);
            }
        } catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

        request.setAttribute("transacoes", transacoes);
        request.getRequestDispatcher("extrato.jsp").forward(request, response);
    }
}
