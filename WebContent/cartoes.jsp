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
    <link rel="stylesheet" href="resources/css/cartoes.css">
    <title>Fintech</title>
</head>
<body>
    <header>
    	<jsp:include page="header.jsp" />
	</header>

	<h1 class="text" style="color: black; text-align: center; margin-top: 80px;">Gerenciar Cartões</h1>
    <div class="container-fluid mt-4">
        <div class="row justify-content-center">
            <!-- Cartão à esquerda -->
            <div class="col-md-6 mb-4 text-center">
                <div class="card" style="margin: 0; border: none;">
                    <div class="card-body">
                        <img src="resources/images/cartaoConta1.png" alt="Imagem do Cartão" class="img-fluid mb-3">
                        <p><strong>Nome:</strong> Ana Maria Santos</p>
                        <p><strong>Data Vencimento</strong> 02/31</p>
                        <p><strong>Limite:</strong> R$ 10.000,00</p>
                        <p><strong>Limite:</strong> R$ 10.000,00</p>
                    </div>
                    <div class="card-footer">
                    <h5 class="card-title">Cartão de Crédito</h5>
                        <!-- Extrato do cartão à esquerda -->
                        <ul class="list-group mx-auto">
                            <li class="list-group-item">Compra no Crédito 1 - R$ 100,00</li>
                            <li class="list-group-item">Parcela do Crédito 1/3 - R$ 50,00</li>
                            <li class="list-group-item">Parcela do Crédito 2/3 - R$ 50,00</li>
                            <li class="list-group-item">Parcela do Crédito 3/3 - R$ 50,00</li>
                        </ul>
                    </div>
                </div>
            </div>

            <!-- Cartão à direita -->
            <div class="col-md-6 mb-4 text-center">
                <div class="card" style="margin: 0; border: none;">
                    <div class="card-body">
                        <img src="resources/images/cartaoConta.png" alt="Imagem do Cartão" class="img-fluid mb-3">
                        <p><strong>Nome:</strong> Ana Maria Santos</p>
                        <p><strong>Agência:</strong> 456</p>
                        <p><strong>Número da Conta:</strong> 0987654321</p>
                        <p><strong>Saldo:</strong> R$ 2000,00</p>
                    </div>
                    <div class="card-footer">
                    	<h5 class="card-title">Cartão de Débito</h5>
                        <!-- Extrato do cartão à direita -->
                        <ul class="list-group">
                            <li class="list-group-item">Compra no Débito 1 - R$ 50,00</li>
                            <li class="list-group-item">Compra no Débito 2 - R$ 30,00</li>
                        </ul>
                    </div>
                </div>
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
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaK2Q7B8e91FNVzjPyyW0"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
        integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>
</body>
</html>
