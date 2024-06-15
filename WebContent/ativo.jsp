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


</head>

<body>
    <header>
        <jsp:include page="header.jsp" />
    </header>

    <main role="main">
        <a href="carteiraInvestimento.jsp" type="button" class="custom-button" style="background-color: #5a5a5a; border-color: #5a5a5a; color: white; cursor: pointer;">Acessar meus Investimentos</a>
        <div class="container mt-5 pt-5">
            <h1 class="text-center mb-4">Investimentos</h1>
            <div class="list-group">
            
                <a class="list-group-item list-group-item-action flex-column align-items-start">
                    <div class="d-flex w-100 justify-content-between">
                        <h4 class="mb-1">Renda Fixa</h4>
                        <h2>420 <small>ativos dispon�veis</small></h2>
                    </div>
                    <p class="mb-1">Investimentos em renda fixa s�o ideais para investidores conservadores ou iniciantes que procuram proteger seu capital e garantir rendimentos previs�veis. Tamb�m s�o recomendados para aqueles que desejam diversificar sua carteira de investimentos com op��es de menor risco.</p>
                    <a type="button" href="listaAtivo.jsp" class="btn btn-primary btn-lg btn-block mt-2" style="background-color: #5a5a5a; border-color: #5a5a5a; color: white;">Acessar<a>
                    <div class="crcle mt-2">
                        <span class="circle"></span>
                        <span class="circle"></span>
                        <span class="circle"></span>
                        <span class="circle"></span>
                        <span class="circle-empty"></span>
                    </div>
                    <p class="mt-2">�ndice de retorno financeiro 4 / 5</p>
                </a>
                
                <a href="#" class="list-group-item list-group-item-action flex-column align-items-start">
                    <div class="d-flex w-100 justify-content-between">
                        <h4 class="mb-1">Fundos Imobili�rios</h4>
                        <h2>285 <small>ativos dispon�veis</small></h2>
                    </div>
                    <p class="mb-1">Fundos imobili�rios s�o indicados para investidores que buscam diversifica��o e renda passiva atrav�s do setor imobili�rio, sem a necessidade de lidar com a administra��o direta de im�veis. S�o uma excelente op��o para quem deseja entrar no mercado imobili�rio de forma simplificada e com maior liquidez.</p>
                    <button type="button" class="btn btn-primary btn-lg btn-block mt-2" style="background-color: #5a5a5a; border-color: #5a5a5a; color: white;">Acessar</button>
                    <div class="crcle mt-2">
                        <span class="circle"></span>
                        <span class="circle"></span>
                        <span class="circle"></span>
                        <span class="circle"></span>
                        <span class="circle-empty"></span>
                    </div>
                    <p class="mt-2">�ndice de retorno financeiro 3.9 / 5</p>
                </a>
                
                <a href="#" class="list-group-item list-group-item-action flex-column align-items-start">
                    <div class="d-flex w-100 justify-content-between">
                        <h4 class="mb-1">Tesouro Direto</h4>
                        <h2>820 <small>ativos dispon�veis</small></h2>
                    </div>
                    <p class="mb-1">O Tesouro Direto � ideal para investidores conservadores ou iniciantes que buscam seguran�a, rentabilidade e flexibilidade. Tamb�m � uma �tima op��o para quem deseja diversificar sua carteira de investimentos com um ativo de baixo risco.</p>
                    <button type="button" class="btn btn-primary btn-lg btn-block mt-2" style="background-color: #5a5a5a; border-color: #5a5a5a; color: white;">Acessar</button>
                    <div class="crcle mt-2">
                        <span class="circle"></span>
                        <span class="circle"></span>
                        <span class="circle"></span>
                        <span class="circle-empty"></span>
                        <span class="circle-empty"></span>
                    </div>
                    <p class="mt-2">�ndice de retorno financeiro 3 / 5</p>
                </a>
                
                <a href="#" class="list-group-item list-group-item-action flex-column align-items-start">
                    <div class="d-flex w-100 justify-content-between">
                        <h4 class="mb-1">A��es</h4>
                        <h2>1350 <small>ativos dispon�veis</small></h2>
                    </div>
                    <p class="mb-1">A��es s�o indicadas para investidores que aceitam maiores riscos em troca da possibilidade de maiores retornos. S�o recomendadas para quem tem um horizonte de investimento de m�dio a longo prazo e busca diversifica��o e crescimento de capital.</p>
                    <button type="button" class="btn btn-primary btn-lg btn-block mt-2" style="background-color: #5a5a5a; border-color: #5a5a5a; color: white;">Acessar</button>
                    <div class="crcle mt-2">
                        <span class="circle"></span>
                        <span class="circle"></span>
                        <span class="circle"></span>
                        <span class="circle"></span>
                        <span class="circle-empty"></span>
                    </div>
                    <p class="mt-2">�ndice de retorno financeiro 4 / 5</p>
                </a>
                
                <a href="#" class="list-group-item list-group-item-action flex-column align-items-start">
                    <div class="d-flex w-100 justify-content-between">
                        <h4 class="mb-1">Fundos de Investimento</h4>
                        <h2>135 <small>ativos dispon�veis</small></h2>
                    </div>
                    <p class="mb-1">Fundos de investimento s�o indicados para investidores que buscam diversifica��o e querem contar com a expertise de gestores profissionais. S�o uma boa op��o tanto para iniciantes quanto para investidores experientes que desejam acessar diferentes mercados e ativos com comodidade.</p>
                    <button type="button" class="btn btn-primary btn-lg btn-block mt-2" style="background-color: #5a5a5a; border-color: #5a5a5a; color: white;">Acessar</button>
                    <div class="crcle mt-2">
                        <span class="circle"></span>
                        <span class="circle"></span>
                        <span class="circle"></span>
                        <span class="circle"></span>
                        <span class="circle-empty"></span>
                    </div>
                    <p class="mt-2">�ndice de retorno financeiro 4.1 / 5</p>                    
                </a>
                
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