<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Language" content="pt-BR">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="resources/images/logo.png">
    <link rel="stylesheet" href="resources/css/conta.css">
    <title>Fintech</title>
</head>
<body>

<header>
    <jsp:include page="header.jsp" />
</header>

<div class="container mt-5"> <!-- Adicionando margem superior -->
    <div class="red-box" style="display: flex; flex-direction: column; justify-content: center; align-items: center;">
        <img src="resources/images/cartao.png" alt="Imagem do Cartão">
        <p>Nome: Fulano de Tal</p>
        <p>Agência: 123</p>
        <p>Número da Conta: 1234567890</p>
        <p>Saldo: R$ 1000,00</p>
    </div>
    
<div class="blue-box" style="padding: 20px; border-radius: 10px; background-color: #2C3E50; overflow: auto; display: flex; flex-direction: column; align-items: center;">
    <table style="width: 100%; color: #FFFFFF; border-collapse: collapse;">
        <thead>
            <tr>
                <th style="font-size: 20px; padding-bottom: 10px; border-bottom: 2px solid #FFFFFF;">Pagamentos Recorrentes</th>
                <th style="font-size: 20px; padding-bottom: 10px; border-bottom: 2px solid #FFFFFF;">Ação</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td style="font-size: 18px; padding-bottom: 10px; border-bottom: 1px solid #FFFFFF;">Assinatura Netflix</td>
                <td style="text-align: center; border-bottom: 1px solid #FFFFFF;">
                    <a href="#" class="button" style="background-color: #3498DB; color: #FFFFFF; padding: 8px 16px; font-size: 16px; border-radius: 5px; text-decoration: none;">Editar</a>
                </td>
            </tr>
            <tr>
                <td style="font-size: 18px; padding-bottom: 10px; border-bottom: 1px solid #FFFFFF;">Plano de Telefonia</td>
                <td style="text-align: center; border-bottom: 1px solid #FFFFFF;">
                    <a href="#" class="button" style="background-color: #3498DB; color: #FFFFFF; padding: 8px 16px; font-size: 16px; border-radius: 5px; text-decoration: none;">Editar</a>
                </td>
            </tr>
            <tr>
                <td style="font-size: 18px; padding-bottom: 10px; border-bottom: 1px solid #FFFFFF;">Conta de Luz</td>
                <td style="text-align: center; border-bottom: 1px solid #FFFFFF;">
                    <a href="#" class="button" style="background-color: #3498DB; color: #FFFFFF; padding: 8px 16px; font-size: 16px; border-radius: 5px; text-decoration: none;">Editar</a>
                </td>
            </tr>
        </tbody>
    </table>
</div>



    <div class="light-blue-box">
        <h2>Outras Opções</h2>
        <div class="button-container">
            <a href="#" class="button">Alterar Senha</a>
            <a href="#" class="button">Ajuda</a>
        </div>
    </div>
    <div class="light-blue-box">
        <h2>...</h2>
        <div class="button-container">
            <a href="#" class="button">Opção 1</a>
            <a href="#" class="button">Opção 2</a>
        </div>
    </div>
</div>

<footer class="container">
    <jsp:include page="footer.jsp" />
</footer>
</body>
</html>
