<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>


<body>
    <header>
        <jsp:include page="header.jsp" />
    </header>

     <div class="col-md-6">
	      <div class="card mb-4">
	          <div class="card-header text-center">Ativos</div>
	          <div class="card-body">
	              <table class="table table-striped mx-auto">
	                  <thead>
	                      <tr>
	                          <th>Descrição</th>
	                          <th>Valor</th>
	                      </tr>
	                  </thead>
	                  <tbody>
		                      <tr>
		                          <td>Renda Fixa</td>
		                          <td>R$ 2.500,00</td>
		                          <td class="text-center">
		                              <a href="#" class="btn btn-info btn-sm">Adicionar a Carteira</a>
		                          </td>
		                      </tr>
		                      <tr>
		                          <td>Renda Fixa</td>
		                          <td>R$ 1.000,00</td>
		                          <td class="text-center">
		                              <a href="#" class="btn btn-info btn-sm">Adicionar a Carteira</a>
		                          </td>
		                      </tr>
		                      <tr>
		                          <td>Renda Fixa</td>
		                          <td>R$ 500,00</td>                                        
		                          <td class="text-center">
		                              <a href="#" class="btn btn-info btn-sm">Adicionar a Carteira</a>
		                          </td>
		                      </tr>
		                      <tr>
		                          <td>Renda Fixa</td>
		                          <td>1.0000,00</td>
		                          <td class="text-center">
		                              <a href="#" class="btn btn-info btn-sm">Adicionar a Carteira</a>
		                          </td>
		                      </tr>
		                      <tr>
		                          <td>Renda Fixa</td>
		                          <td>1.0000,00</td>
		                          <td class="text-center">
		                              <a href="#" class="btn btn-info btn-sm">Adicionar a Carteira</a>
		                          </td>
		                      </tr>
		                      <tr>
		                          <td>Renda Fixa</td>
		                          <td>1.0000,00</td>
		                          <td class="text-center">
		                              <a href="#" class="btn btn-info btn-sm">Adicionar a Carteira</a>
		                          </td>
		                      </tr>
		                      <tr>
		                          <td>Renda Fixa</td>
		                          <td>1.0000,00</td>
		                          <td class="text-center">
		                              <a href="#" class="btn btn-info btn-sm">Adicionar a Carteira</a>
		                          </td>
		                      </tr>
		                      <tr>
		                          <td>Renda Fixa</td>
		                          <td>1.0000,00</td>
		                          <td class="text-center">
		                              <a href="#" class="btn btn-info btn-sm">Adicionar a Carteira</a>
		                          </td>
		                      </tr>
		                      <tr>
		                          <td>Renda Fixa</td>
		                          <td>1.0000,00</td>
		                          <td class="text-center">
		                              <a href="#" class="btn btn-info btn-sm">Adicionar a Carteira</a>
		                          </td>
		                      </tr>
		                      <tr>
		                          <td>Renda Fixa</td>
		                          <td>1.0000,00</td>
		                          <td class="text-center">
		                              <a href="#" class="btn btn-info btn-sm">Adicionar a Carteira</a>
		                          </td>
		                      </tr>
		                      <tr>
		                          <td>Renda Fixa</td>
		                          <td>1.0000,00</td>
		                          <td class="text-center">
		                              <a href="#" class="btn btn-info btn-sm">Adicionar a Carteira</a>
		                          </td>
		                      </tr>
		                      <tr>
		                          <td>Renda Fixa</td>
		                          <td>1.0000,00</td>
		                          <td class="text-center">
		                              <a href="#" class="btn btn-info btn-sm">Adicionar a Carteira</a>
		                          </td>
		                      </tr>
		                      <tr>
		                          <td>Renda Fixa</td>
		                          <td>1.0000,00</td>
		                          <td class="text-center">
		                              <a href="#" class="btn btn-info btn-sm">Adicionar a Carteira</a>
		                          </td>
		                      </tr>
		                      <tr>
		                          <td>Renda Fixa</td>
		                          <td>1.0000,00</td>
		                          <td class="text-center">
		                              <a href="#" class="btn btn-info btn-sm">Adicionar a Carteira</a>
		                          </td>
		                      </tr>
		                      
		                      <tr>
		                      	<c:forEach items="${investimento}" var="p">
		                       
			                       <td><c:url value="investimento" var="link">
									<c:param name="acao" value="abrir-form-editar" />
									<c:param name="codigo_ativo" value="${p.codigo_ativo}" /> 
									<c:param name="codigo_carteira" value="${p.codigo_carteira}" />
									<c:param name="quantidade" value="${p.quantidade}" />
									</c:url> <a href="${link}" class="btn btn-primary btn-xs">Adicionar a Carteira</a></td>
									
								</c:forEach>	
							  </tr>					
	                           
	                       </tbody>
	                   </table>
	               </div>
	           </div>
	       </div>

    <footer class="container">
        <jsp:include page="footer.jsp" />
    </footer>

   
</body>
</html>