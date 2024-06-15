<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Language" content="pt-BR">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="resources/images/logo.png">
    <link rel="stylesheet" href="resources/css/ativo.css" type="text/css">

    <title>Fintech</title>
</head>

<body>
    <header>
        <jsp:include page="header.jsp" />
    </header>

     <div class="col-md-6">
                    <div class="card mb-4">
                        <div class="card-header text-center">Pagamentos Recorrentes</div>
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
                                        <td>R$ 500,00</td>                                        <td class="text-center">
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
                                    </tr>
                                    <c:forEach items="${investimento}" var="p">
                                    
                                    <td><c:url value="investimento" var="link">
													<c:param name="acao" value="abrir-form-editar" />
 													<c:param name="codigo_ativo" value="${p.codigo_ativo}" /> 
 													<c:param name="codigo_carteira" value="${p.codigo_carteira}" />
 													<c:param name="quantidade" value="${p.quantidade}" />
												</c:url> <a href="${link}" class="btn btn-primary btn-xs">Adicionar a Carteira</a></td>
										</tr>
									</c:forEach>
                                    
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>

    <footer class="container">
        <jsp:include page="footer.jsp" />
    </footer>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaK2Q7B8e91FNVzjPyyW0fM5bvi1jzWQKj5i"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
        integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>
</body>
</html>