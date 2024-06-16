<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<body>
    <header>
        <jsp:include page="header.jsp" />
    </header>
    <main role="main" class="container mt-5 pt-5" style="display: flex; justify-content: center;">
        <div class="col-md-4">
                <div class="card mb-4">
                    <div class="card-header">Editar Investimento</div>
                    <div class="card-body">
                    
<!--                     Alerta de erro -->
                    <c:if test="${not empty msg }">
						<div class="alert alert-success">${msg}</div>
					</c:if>
					
					<c:if test="${not empty erro }">
						<div class="alert alert-danger">${erro}</div>
					</c:if>
					
                        <form action="investimento" method= "post">
                            <div class="form-group">
                                <label for="id-valor">Valor (R$)</label>
                                <input type="number" class="form-control" id="id-valor" required>
                            </div>
                            <input type="submit" value="Salvar" class="btn btn-primary">
        					<a href="carteiraInvestimento.jsp" class="btn btn-danger">Cancelar</a>
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
