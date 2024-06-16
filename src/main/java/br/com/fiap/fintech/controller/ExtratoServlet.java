package br.com.fiap.fintech.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
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

@WebServlet("/ExtratoServlet")
public class ExtratoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String contaId = request.getParameter("contaId");

        List<Transacao> transacoes = new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "user", "password");

            String sql = "SELECT 'DEPOSITO' AS tipo, dt_deposito AS data, vl_deposito AS valor FROM T_DEPOSITO WHERE cd_conta = ? " +
                         "UNION ALL " +
                         "SELECT 'DESPESA' AS tipo, dt_despesa AS data, vl_gasto AS valor FROM T_DESPESA WHERE cd_conta = ? " +
                         "ORDER BY data";
            PreparedStatement statement = connection.prepareStatement(sql);
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

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("transacoes", transacoes);
        request.getRequestDispatcher("extrato.jsp").forward(request, response);
    }
}
