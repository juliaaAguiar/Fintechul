<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Language" content="pt-BR">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="resources/images/logo.png">
    <link rel="stylesheet" href="resources/css/gerenciarConta.css" type="text/css">
    <title>Fintech</title>
    <!-- Bootstrap CSS principal -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" 
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>

    <header>
        <jsp:include page="header.jsp" />
    </header>

    <main>
        <section class="account">
            <h2>Conta</h2>
            <p>Gerencie sua conta aqui.</p>
        </section>

        <section class="balance">
            <h2>Saldo</h2>
            <p>Seu saldo atual é: R$ 1.000,00</p>
        </section>

        <section class="transfers">
            <h2>Transferências</h2>
            <p>Realize transferências aqui.</p>
        </section>

        <section class="account-details">
            <h2>Detalhes da Conta</h2>
            <p>Visualize os detalhes da sua conta aqui.</p>
        </section>

        <section class="cards">
            <h2>Cartões</h2>
            <p>Visualize seus cartões de crédito e débito aqui.</p>
        </section>
    </main>

    <footer class="container">
        <jsp:include page="footer.jsp" />
    </footer>
</body>
</html>
