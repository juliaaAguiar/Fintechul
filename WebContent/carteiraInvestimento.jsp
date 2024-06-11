<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Language" content="pt-BR">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="resources/images/logo.png">
    <link rel="stylesheet" href="resources/css/index.css" type="text/css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
        integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link rel="stylesheet" href="resources/css/carteiraInvestimento.css" type="text/css">
    <title>Fintech - Carteira de Investimentos</title>
</head>

<body>
    <header>
        <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
            <a class="navbar-brand" href="#">Fintech</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse"
                aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarCollapse">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="index.jsp">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="dashboard.jsp">Receita/Despesa</a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="#">Investimento</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Conta</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="ajuda.jsp">Ajuda</a>
                    </li>
                </ul>
                <form class="form-inline mt-2 mt-md-0">
                    <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Pesquisar</button>
                </form>
            </div>
        </nav>
    </header>

    <main role="main" class="container mt-5 pt-5">
        <h1 class="text-center mb-4">Carteira de Investimentos</h1>
        <h2 class="text-center mb-4">Total Investido: R$ 100.000,00</h2>
        <div class="row">
            <div class="col-md-8">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>Inicio</th>
                            <th>Tipo</th>
                            <th>Término</th>
                            <th>Valor Investido</th>
                            <th>Retorno</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>10/06/2024</td>
                            <td>Renda Fixa</td>
                            <td>10</td>
                            <td>R$ 1.000,00</td>
                            <td>1%</td>
                        </tr>
                        <tr>
                            <td>05/06/2024</td>
                            <td>Fundos Imobiliários</td>
                            <td>5</td>
                            <td>R$ 2.500,00</td>
                            <td>2.5%</td>
                        </tr>
                        <!-- Adicione mais linhas conforme necessário -->
                    </tbody>
                </table>
            </div>
            <div class="col-md-4">
                <div class="card mb-4">
                    <div class="card-header">Detalhes da Carteira</div>
                    <div class="card-body">
                        <ul class="list-group">
                            <li class="list-group-item d-flex justify-content-between align-items-center">
                                Renda Fixa
                                <span class="badge badge-primary badge-pill">40%</span>
                            </li>
                            <li class="list-group-item d-flex justify-content-between align-items-center">
                                Fundos Imobiliários
                                <span class="badge badge-primary badge-pill">20%</span>
                            </li>
                            <li class="list-group-item d-flex justify-content-between align-items-center">
                                Tesouro Direto
                                <span class="badge badge-primary badge-pill">25%</span>
                            </li>
                            <li class="list-group-item d-flex justify-content-between align-items-center">
                                Ações
                                <span class="badge badge-primary badge-pill">10%</span>
                            </li>
                            <li class="list-group-item d-flex justify-content-between align-items-center">
                                Fundos de Investimento
                                <span class="badge badge-primary badge-pill">5%</span>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </main>

    <footer class="container mt-5">
        <p class="float-right"><a href="#">Voltar ao topo</a></p>
        <p>&copy; 2024 Fintech. Todos os direitos reservados.</p>
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
