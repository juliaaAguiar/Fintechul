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
    <link rel="stylesheet" href="resources/css/login.css" type="text/css">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    <title>Fintech</title>

    <!-- Bootstrap CSS principal -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" 
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    <!-- Estilos personalizados -->
</head>
<body>

<div class="sidenav">
    <div class="login-main-text">
        <div class="logo-container">
            <img src="resources/images/logo.png" alt="Logo" class="logo-img">
            <h2>Fintech</h2>
        </div>
    </div>
</div>
<div class="main">
    <div class="col-md-6 col-sm-12">
        <div class="login-form">
            <div class="form-group">
                <label>Email</label>
                <input type="text" class="form-control" placeholder="Email">
            </div>
            <div class="form-group">
                <label>CPF</label>
                <input type="tel" class="form-control" placeholder="CPF" pattern="\d{3}\.\d{3}\.\d{3}-\d{2}">
            </div>	
            <div class="form-group">
                <label>Senha</label>
                <input type="password" class="form-control" placeholder="Senha">
            </div>
            <a href="index.jsp" class="btn custom-btn">Acessar</a>
        </div>
    </div>
</div>

</body>
</html>
