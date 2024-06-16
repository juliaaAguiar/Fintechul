<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Language" content="pt-BR">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="resources/images/logo.png">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
<link rel="stylesheet" href="resources/css/contadet.css">
<title>Fintech</title>
</head>
<body>
	<header style="background-color: lightgray;">
		<jsp:include page="header.jsp" />
	</header>

	<h1 class="text"
		style="color: black; text-align: center; margin-top: 80px;">Informações
		da Conta</h1>
	<div class="container-fluid justify-content-center h-100">
		<!-- Removido align-items-center -->
		<main role="main">
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
											<td><fmt:formatDate value="${p.data.time}" 
													pattern="dd/MM/yyyy" /></td>  
													
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
													
													<td><c:url value="investimento" var="link">
													<c:param name="acao" value="abrir-form-editar" />
 													<c:param name="codigo_ativo" value="${p.codigo_ativo}" /> 
 													<c:param name="codigo_carteira" value="${p.codigo_carteira}" />
												</c:url> <a href="${link}" class="btn btn-primary btn-xs">Adicionar a Carteira</a>
												<button type="button" class="btn btn-danger btn-xs"
													data-toggle="modal" data-target="#excluirModal"
 													onclick="codigoExcluir.value = ${p.codigo}"> 
													Excluir</button></td>
										</tr>
									</c:forEach>
							</table>
						</div>

						<%@ include file="footer.jsp"%>

						<!-- Modal -->
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
						</tbody>
						</table>
					</div>
				</div>
			</div>

			<div class="col-md-12 text-center">
				<div class="card mb-4">
					<div class="card-header">Outras Opções</div>
					<div class="card-body">
						<a href="cartoes.jsp" class="btn btn-secondary btn-block mb-2">Cartões</a>
					 	<c:url value="/extrato" var="urlExtrato">
		                	<c:param name="contaId" value="1" />
	            		</c:url>
			            <a href="${urlExtrato}" class="btn btn-primary btn-block">Extrato</a>
					</div>
				</div>
			</div>
	</div>
	</main>
	</div>

	<footer class="container-fluid" style="height: 60px;">
		<jsp:include page="footer.jsp" />
	</footer>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaK2Q7B8e91FNVzjPyyW0fM5bvi1jzWQKj5i"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous"></script>
</body>
</html>
