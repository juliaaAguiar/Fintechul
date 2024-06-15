<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<body>
    <header>
       <jsp:include page="header.jsp" />
    </header>

    <main role="main" class="container mt-5 pt-5">
        <h1 class="text-center mb-4">Carteira de Investimentos</h1>
        <h2 class="text-center mb-4" style="background-color: #f0f0f0; padding: 10px; border-radius: 8px; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);">Total Investido: R$ 100.000,00</h2>
        <div class="row">
            <div class="col-md-8">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>Aquisição</th>
                            <th>Tipo</th>
                            <th>Quantidade</th>
                            <th>Valor Ind.</th>
                            <th>Valor Inv.</th>
                            <th>Alterar</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${ativo}" var="a">
							<tr>	
<!-- 	 Aqui são as informações da carteira, que deveriam vir da lista de ativos  -->
							    <td>$</td>							    
							    <td>$</td>
							    <td>$</td>							    
							    <td>$</td>
								<td>$</td>									    
							    
								<td><c:url value="pagamentorecorrente" var="link">
									<c:param name="acao" value="abrir-form-edicao" />
									<c:param name="codigo" value="${p.codigo}" /> 
									</c:url> <a href="${link}" class="btn btn-primary btn-xs">Editar</a>
									<button type="button" class="btn btn-danger btn-xs"
									data-toggle="modal" data-target="#excluirModal"
										onclick="codigoExcluir.value = ${p.codigo}"> 
									Excluir</button>
								</td>
							</tr>
						</c:forEach>
                    </tbody>
                </table>
            </div>
        </div>    
            
            
            <!-- Modal  para confirmar ação de excluir-->
						<div class="modal fade" id="excluirModal" tabindex="-1"
							role="dialog" aria-labelledby="exampleModalLabel"
							aria-hidden="true">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="exampleModalLabel">Confirmação</h5>
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
									<div class="modal-body">Deseja realmente excluir o
										lançamento?</div>
									<div class="modal-footer">
										<form action="produto" method="post">
											<input type="hidden" name="acao" value="excluir"> <input
												type="hidden" name="codigo" id="codigoExcluir">
											<button type="button" class="btn btn-secondary"
												data-dismiss="modal">Cancelar</button>
											<button type="submit" class="btn btn-danger">Excluir</button>
										</form>
									</div>
								</div>
							</div>
						</div>		

					
				
<!-- 		Detalhes da Carteira 		 -->
            <div class="col-md-4">
                <div class="card mb-4">
                    <div class="card-header">Detalhes da Carteira</div>
                    <div class="card-body">
                        <ul class="list-group">
                            <li class="list-group-item d-flex justify-content-between align-items-center">
                                Renda Fixa
                                <span class="badge badge-primary badge-pill">13,03%</span>
                            </li>
                            <li class="list-group-item d-flex justify-content-between align-items-center">
                                Fundos Imobiliários
                                <span class="badge badge-primary badge-pill">16,30%</span>
                            </li>
                            <li class="list-group-item d-flex justify-content-between align-items-center">
                                Tesouro Direto
                                <span class="badge badge-primary badge-pill">16,30%</span>
                            </li>
                            <li class="list-group-item d-flex justify-content-between align-items-center">
                                Ações
                                <span class="badge badge-primary badge-pill">45,58%</span>
                            </li>
                            <li class="list-group-item d-flex justify-content-between align-items-center">
                                Fundos de Investimento
                                <span class="badge badge-primary badge-pill">8,79%</span>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        
    </main>

    <footer class="container">
        <jsp:include page="footer.jsp" />
    </footer>

</body>

</html>
	