<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

<title>Contas Cadastradas</title>
<%@ include file="header.jsp" %>
</head>
<body>

<div class="container">
	<h1 class="text-center">Contas Cadastradas</h1>
	
	<div>
		<a href="cadastrarConta.jsp" type="submit" class="btn btn-sm btn-success my-2">Cadastar nova Conta</a>
	</div>
	
	<table class="table table-striped">
		<tr>
			<th>Agência</th>
			<th>Número</th>
			<th>Saldo</th>
			<th>Tipo</th>
			<th>Usuário</th>
			<th>Atualizar</th>
			<th>Excluir</th>
		</tr>
		
			<tr>
				<td>Teste</td>
				<td>Teste</td>
				<td>Teste</td>
				<td>Teste</td>	
				<td>Teste</td>	
				<td>
					<a href="atualizarConta.jsp" type="submit" class="btn btn-sm btn-success tex-center">
					<i class="bi bi-pencil-square"></i>	</a>
				</td>	
				<td>
					<button type="submit" class="btn btn-sm btn-danger text-center">
					<i class="bi bi-trash3"></i></button>
				</td>								
			</tr>
	
	</table>
	
	
</div>


<%@ include file="footer.jsp" %>

</body>
</html>