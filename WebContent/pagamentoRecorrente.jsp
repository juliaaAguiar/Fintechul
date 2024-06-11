<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<link rel="stylesheet" href="style.css">

<title>Pagamento Recorrente</title>
<%@ include file="header.jsp" %>
</head>
<body>

<%@ include file="menu.jsp" %>
<div class="container">
	<h1 class="text-center">Pagamento Recorrente</h1>
	
	<div>
		<a href="cadastrarConta.jsp" type="submit" class="btn btn-sm btn-success my-2">Cadastar novo Pagamento</a>
	</div>
	
	<table class="table table-striped">
		<tr>
			<th>Data</th>	
			<th>Nome</th>
			<th>Valor</th>			
			<th>Atualizar</th>
			<th>Excluir</th>		
		</tr>
		
			<tr>
				<td>Teste</td>
				<td>Teste</td>
				<td>Teste</td>
				
				<td>
					<a href="" type="submit" class="btn btn-sm btn-success tex-center">
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