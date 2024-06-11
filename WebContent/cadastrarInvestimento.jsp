<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

<title>Carteira de investimento</title>
<%@ include file="header.jsp" %>
</head>
<body>

<%@ include file="menu.jsp" %>
<div class="container">
	<h1 class="text-center">Carteira de Investimentos</h1>
	
	<div>
		<a href="cadastrarAtivo.jsp" type="submit" class="btn btn-sm btn-success my-2">Cadastrar novo investimento</a>
	</div>
	
	<table class="table table-striped">
		<tr>
			<th>Código Investimento</th>
			<th>Quantidade de ativos</th>
			<th>Total de Ativos</th>
			<th>Conta</th>
			<th>Atualizar</th>
			<th>Excluir</th>
		</tr>
		
			<tr>
				<td>Teste</td>
				<td>Teste</td>
				<td>Teste</td>
				<td>Teste</td>	
				<td>
					<a type="submit" href="atualizarAtivo.jsp" class="btn btn-sm btn-success">
					<i class="bi bi-pencil-square"></i></a>
				</td>	
				<td>
					<button type="submit" class="btn btn-sm btn-danger">
					<i class="bi bi-trash3"></i></button>
				</td>		
			</tr>		
	</table>
	
	
	
	
</div>
<%@ include file="footer.jsp" %>

</body>
</html>