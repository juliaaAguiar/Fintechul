<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Language" content="pt-BR">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="resources/images/logo.png">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
        integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link rel="stylesheet" href="resources/css/conta.css">
    <title>Fintech</title>
</head>
<body>
    <header>
        <jsp:include page="header.jsp" />
    </header>

    <main role="main" class="container mt-5 pt-5">
        <h1 class="text-center mb-4">Informações da Conta</h1>
        <div class="row">
            <div class="col-md-4">
                <div class="card mb-4">
                    <div class="card-body text-center">
                        <img src="resources/images/cartao.png" alt="Imagem do Cartão" class="img-fluid mb-3">
                        <p class="mb-1"><strong>Nome:</strong> Fulano de Tal</p>
                        <p class="mb-1"><strong>Agência:</strong> 123</p>
                        <p class="mb-1"><strong>Número da Conta:</strong> 1234567890</p>
                        <p class="mb-1"><strong>Saldo:</strong> R$ 1000,00</p>
                    </div>
                </div>
            </div>
            
            <div class="col-md-4">
                <div class="card mb-4">
                    <div class="card-header">Pagamentos Recorrentes</div>
                    <div class="card-body">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th>Descrição</th>
                                    <th>Ação</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>Assinatura Netflix</td>
                                    <td class="text-center">
                                        <a href="#" class="btn btn-primary btn-sm">Editar</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>Plano de Telefonia</td>
                                    <td class="text-center">
                                        <a href="#" class="btn btn-primary btn-sm">Editar</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>Conta de Luz</td>
                                    <td class="text-center">
                                        <a href="#" class="btn btn-primary btn-sm">Editar</a>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

            <div class="col-md-4">
                <div class="card mb-4">
                    <div class="card-header">Outras Opções</div>
                    <div class="card-body text-center">
                        <a href="#" class="btn btn-secondary btn-block mb-2">Cartões</a>
                        <a href="#" class="btn btn-secondary btn-block">Extrato</a>
                    </div>
                </div>
            </div>
        </div>
    </main>

    <footer class="container" style="height: 60px;">
    	<jsp:include page="footer.jsp" />
	</footer>


    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaK2Q7B8e91FNVzjPyyW0"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
        integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>
</body>
</html>
