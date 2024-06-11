<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Atualizar Investimento</title>
<%@ include file="header.jsp" %>
</head>
<body>
<%@ include file="menu.jsp" %>

<div class="container">
	<h2 class="text-center">Atualizar Investimento</h2>

	
	<form method="post">	
		
	  <div class="form-group mb-3">
	    <label  class="form-label">Tipo de Ativo</label>
	    <input type="text" class="form-control">		    
	  </div>
	  
	    <div class="form-group mb-3">
		    <label  class="form-label">Nome</label>
		    <input type="text" class="form-control">		    
	  </div>
	  
	  <div class="mb-3">
	    <label  class="form-label">Valor Atual</label>
	    <input type="number" class="form-control">
	  </div> 
	  	  
	   <div class="form-group mb-3">
		    <label  class="form-label">Descrição</label>
		    <input type="text" class="form-control">		    
	  </div>
	  
	  
	  <button type="submit" class="btn btn-sm btn-success">Atualizar</button>
	  
	  <a type="submit" href="carteiraInvestimento.jsp" class="btn btn-sm btn-success p-1">Voltar</a>
	</form>	
</div>
	
	<%@ include file="footer.jsp" %>
</body>
</html>