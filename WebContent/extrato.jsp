<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="br.com.fiap.fintech.bean.Transacao" %>

<html>
<head>
    <title>Extrato</title>
</head>
<body>
<h2>Extrato de Transações</h2>
<table border="1">
    <thead>
    <tr>
        <th>Tipo</th>
        <th>Data</th>
        <th>Valor</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="transacao" items="${transacoes}">
        <tr>
            <td><c:out value="${transacao.tipo}"/></td>
            <td><c:out value="${transacao.data}"/></td>
            <td><c:out value="${transacao.valor}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
