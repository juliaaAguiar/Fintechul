<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 

<body>
	<header style="background-color: lightgray;">
		<jsp:include page="header.jsp" />
	</header>

	<h1 class="text"
		style="color: black; text-align: center; margin-top: 80px;">Informações
		da Conta</h1>
		
	<main role="main">
		<div class="container-fluid justify-content-center h-100">
		<!-- Removido align-items-center -->
		
				<div class="row justify-content-center">
					<!-- Coluna para o cartão -->
					<div class="col-md-6 text-center">
						<div class="card mb-4 account-info">
							<div class="card-body">
								<img src="resources/images/cartaoConta.png"
									alt="Imagem do Cartão" class="img-fluid mb-3">
								<p>
									<strong>Nome:</strong> Ana Maria Santos
								</p>
								<p>
									<strong>Tipo:</strong> Conta Corrente
								</p>
								<p>
									<strong>Agência:</strong> 456
								</p>
								<p>
									<strong>Número da Conta:</strong> 0987654321
								</p>
								<p>
									<strong>Saldo:</strong> R$ 2000,00
								</p>
							</div>
						</div>
					</div>
	
					<!-- Coluna para os pagamentos recorrentes -->
					<div class="col-md-6">
						<div class="card mb-4">
							<div class="card-header text-center">Pagamentos Recorrentes</div>
							<div class="card-body">
								<table class="table table-striped mx-auto">
								<thead>
	                                    <tr>
	                                    	<th>Data</th>
	                                        <th>Descrição</th>
	                                        <th>Valor</th>
	                                        <th>Ação</th>
	                                    </tr>
	                                </thead>
									<tbody>
										<c:forEach items="${pagamentosrecorrentes}" var="p">
											<tr>
												<td><fmt:formatDate value="${p.data.time}" pattern="dd/MM/yyyy" /></td>  
														
												    <td>${p.nome}</td>
												    
												    <td>${p.valor}</td>
												<td><c:url value="pagamentorecorrente" var="link">
														<c:param name="acao" value="abrir-form-edicao" />
	 													<c:param name="codigo" value="${p.codigo}" /> 
													</c:url> <a href="${link}" class="btn btn-primary btn-xs">Editar</a>
													<button type="button" class="btn btn-danger btn-xs"
														data-toggle="modal" data-target="#excluirModal"
	 													onclick="codigoExcluir.value = ${p.codigo}"> 
														Excluir</button></td>
											</tr>
										</c:forEach>
									</tbody>									
								</table>
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
							
						</div>
					</div>
				</div>
	
				<!-- Coluna para outras opções -->
				<div class="col-md-12 text-center">
					<div class="card mb-4">
						<div class="card-header">Outras Opções</div>
						<div class="card-body">
							<a href="cartoes.jsp" class="btn btn-secondary btn-block mb-2">Cartões</a>
							<a href="extrato.jsp" class="btn btn-secondary btn-block">Extrato</a>
						</div>
					</div>
				</div>
			</div>
	</main>
	

	<footer class="container-fluid" style="height: 60px;">
		<jsp:include page="footer.jsp" />
	</footer>

</body>
</html>
