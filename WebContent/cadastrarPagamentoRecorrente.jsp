<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pagamento Recorrente</title>
<%@ include file="header.jsp" %>
</head>
<body>
<%@ include file="menu.jsp" %>

<div class="container">
	<h2 class="text-center"> Cadastrar Pagamento Recorrente</h2>

	
	<form method="post">
	
	  <div class="form-group mb-3">
	    <label  class="form-label">Data</label>
	    <input type="date" class="form-control">
	  </div>	
	
	 <div class="form-group mb-3">
		    <label  class="form-label">Nome</label>
		    <input type="text" class="form-control">		    
	  </div>
		
	  <div class="form-group mb-3">
	    <label  class="form-label">Valor</label>
	    <input type="number" class="form-control">		    
	  </div>  
	  
	   
	  
	  <div class="mb-3">
	    <label  class="form-label">Conta</label>
	    <input type="number" class="form-control">
	  </div>
	  
	  <button type="submit" class="btn btn-sm btn-success">Salvar</button>
	  <a type="submit" href="pagamentoRecorrente.jsp" class="btn btn-sm btn-success p-1">Voltar</a>
	</form>	
</div>
	
	<%@ include file="footer.jsp" %>
</body>
</html>