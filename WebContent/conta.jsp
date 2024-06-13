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
    <link rel="stylesheet" href="resources/css/contadet.css">
    <title>Fintech</title>
</head>
<body>
    <header style="background-color: lightgray;">
    	<jsp:include page="header.jsp" />
	</header>


	<h1 class="text" style="color: black; text-align: center; margin-top: 80px;">Informações da Conta</h1>
    <div class="container-fluid justify-content-center h-100"> <!-- Removido align-items-center -->
        <main role="main">
            <div class="row justify-content-center">
                <!-- Coluna para o cartão -->
                <div class="col-md-6 text-center">
    <div class="card mb-4 account-info">
        <div class="card-body">
            <img src="resources/images/cartaoConta.png" alt="Imagem do Cartão" class="img-fluid mb-3">
            <p><strong>Nome:</strong> Fulano de Tal</p>
            <p><strong>Agência:</strong> 123</p>
            <p><strong>Número da Conta:</strong> 1234567890</p>
            <p><strong>Saldo:</strong> R$ 1000,00</p>
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
            <th>Descrição</th>
            <th>Ação</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>Assinatura Netflix</td>
            <td class="text-center">
                <a href="#" class="btn btn-info btn-sm">Editar</a>
            </td>
        </tr>
        <tr>
            <td>Plano de Telefonia</td>
            <td class="text-center">
                <a href="#" class="btn btn-info btn-sm">Editar</a>
            </td>
        </tr>
        <tr>
            <td>Conta de Luz</td>
            <td class="text-center">
                <a href="#" class="btn btn-info btn-sm">Editar</a>
            </td>
        </tr>
        <tr>
            <td>Faculdade</td>
            <td class="text-center">
                <a href="#" class="btn btn-info btn-sm">Editar</a>
            </td>
        </tr>
        <tr>
            <td>Aluguel</td>
            <td class="text-center">
                <a href="#" class="btn btn-info btn-sm">Editar</a>
            </td>
        </tr>
    </tbody>
</table>

                        </div>
                    </div>
                </div>

                <!-- Coluna para outras opções -->
                <div class="col-md-12 text-center">
                    <div class="card mb-4">
                        <div class="card-header">Outras Opções</div>
                        <div class="card-body">
                            <a href="cartoes.jsp" class="btn btn-secondary btn-block mb-2">Cartões</a>
                            <a href="estrato.jsp" class="btn btn-secondary btn-block">Extrato</a>
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
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaK2Q7B8e91FNVzjPyyW0"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
        integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>
</body>
</html>
