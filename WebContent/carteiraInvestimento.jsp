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
    <link rel="stylesheet" href="resources/css/carteiraInvestimento.css" type="text/css">
    
    <title>Fintech - Carteira de Investimentos</title>
</head>

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
                        <tr>
                            <td>10/06/2024</td>
                            <td>Renda Fixa</td>
                            <td>2</td>
                            <td>R$ 1.000,00</td>
                            <td>2.000,00</td>
							<td>
                                <button type="button" class="btn btn-info btn-sm">Alterar</button>
                            </td>
                        </tr>
                        <tr>
                            <td>05/06/2024</td>
                            <td>Fundos Imobiliários</td>
                            <td>5</td>
                            <td>R$ 500,00</td>
                            <td>2.500,00</td>
                            <td>
                                <button type="button" class="btn btn-info btn-sm">Alterar</button>
                            </td>
                        </tr>
                        <tr>
                            <td>05/06/2024</td>
                            <td>Tesouro Direto</td>
                            <td>2%</td>
                            <td>R$ 100,00</td>
                            <td>2.500,00</td>
                            <td>
                                <button type="button" class="btn btn-info btn-sm">Alterar</button>
                            </td>
                        </tr>
                        <tr>
                            <td>05/06/2024</td>
                            <td>Ações</td>
                            <td>2</td>
                            <td>R$ 3.500,00</td>
                            <td>7.500,00</td>
                            <td>
                                <button type="button" class="btn btn-info btn-sm">Alterar</button>
                            </td>
                        </tr>
                        <tr>
                            <td>05/06/2024</td>
                            <td>Fundos de Investimento</td>
                            <td>15</td>
                            <td>R$ 90,00</td>
                            <td>1.350,00</td>
                            <td>
                                <button type="button" class="btn btn-info btn-sm">Alterar</button>
                            </td>
                        </tr>	
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
        </div>
    </main>

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
	