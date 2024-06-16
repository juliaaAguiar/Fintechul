<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<body>
    <header>
        <jsp:include page="header.jsp" />
    </header>
    
	<h1 class="text" style="color: black; text-align: center; margin-top: 80px;">Atualizar Receitas</h1>
    <main role="main" class="container mt-5 pt-5">
           <div class="col-md-4">
               <div class="card mb-4">
                   <div class="card-header">Atualizar Receita</div>
                   <div class="card-body">
                   
<!--                     Alerta de erro -->
                   <c:if test="${not empty msg }">
						<div class="alert alert-success">${msg}</div>
				   </c:if>
				
					<c:if test="${not empty erro }">
						<div class="alert alert-danger">${erro}</div>
					</c:if>
				
                       <form action="deposito" method="post">
                       	<input type="hidden" value="atualizar" name="acao">
                       	
                           <div class="form-group">
                               <label for="data">Data</label>
                               <input type="date" class="form-control" name="data" id="id-data" required>
                           </div>
                           <div class="form-group">
                               <label for="descricao">Descrição</label>
                               <input type="text" class="form-control" name="descricao" id="id-descricao" required>
                           </div>
                           
                           <div class="form-group">
                               <label for="valor">Valor (R$)</label>
                               <input type="number" class="form-control" name="valor" id="id-valor" required>
                           </div>
                           <input type="submit" value="Atualizar" class="btn btn-primary btn-block" style="background-color: #5a5a5a; border-color: #5a5a5a; color: white;">
                           <a href="extrato.jsp" class="btn btn-danger">Cancelar</a>
                       </form>
                   </div>
               </div>
           </div>        
    </main>

    <footer class="container">
        <jsp:include page="footer.jsp" />
    </footer>

	
</body>
</html>
