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
    <link rel="stylesheet" href="resources/css/index.css" type="text/css">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    
    <title>Fintech</title>
</head>
<body>

<header>
    <jsp:include page="header.jsp" />
</header>

<main role="main">

    <div id="myCarousel" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img class="first-slide" src="resources/images/organizacao.jpg">
                <div class="container">
                    <div class="carousel-caption text-rigth" style="color: black;">
                        <h1>Simplifique suas finan&ccedil;as com a Fintech.</h1>
                        <p>Simplificamos suas finan&ccedil;as para que voc&ecirc; possa focar no que realmente importa.</p>
                    </div>
                </div>
            </div>
            <div class="carousel-item">
                <img class="second-slide" src="resources/images/simpli.jpg" class="responsive" alt="Second slide">
                <div class="container">
                    <div class="carousel-caption text-rigth" style="color: black;">
                        <h1>Aqui organize de forma f&aacute;cil sua vida financeira.</h1>
                        <p>Organize sua vida financeira de forma simples e eficaz aqui na Fintech! Nossa plataforma intuitiva e ferramentas poderosas facilitam o controle dos seus recursos.</p>
                    </div>
                </div>
            </div>
            <div class="carousel-item">
                <img class="third-slide" src="resources/images/investimento.jpg" class="responsive" alt="Third slide">
                <div class="container">
                    <div class="carousel-caption text-rigth" style="color: black;">
                        <h1>Explore oportunidades de investimento na nossa plataforma!.</h1>
                        <p>Deixe seu dinheiro trabalhar para voc&ecirc; enquanto voc&ecirc; foca no que &eacute; importante.</p>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Conteúdo -->

    <div class="container marketing">

        <!-- Three columns of text below the carousel -->
        <div class="row">
            <div class="col-lg-4">
                <img class="rounded-circle" src="resources/images/image3.png" alt="Generic placeholder image" width="140" height="140">
                <h2>Descomplicado</h2>
                <p>Simplificamos todos os processos para que voc&ecirc; possa administrar suas finan&ccedil;as com efici&ecirc;ncia, sem complica&ccedil;&otilde;es.</p>
            </div><!-- /.col-lg-4 -->
            <div class="col-lg-4">
                <img class="rounded-circle" src="resources/images/image2.png" alt="Generic placeholder image" width="140" height="140">
                <h2>Inovador</h2>
                <p>Introduzindo novas abordagens para que voc&ecirc; possa aproveitar ao m&aacute;ximo suas oportunidades financeiras.</p>
            </div><!-- /.col-lg-4 -->
            <div class="col-lg-4">
                <img class="rounded-circle" src="resources/images/image1.png" alt="Generic placeholder image" width="140" height="140">
                <h2>Seguro</h2>
                <p>Oferecemos uma plataforma segura para que voc&ecirc; possa gerenciar suas finan&ccedil;as com tranquilidade e confian&ccedil;a.</p>
            </div><!-- /.col-lg-4 -->
        </div><!-- /.row -->


        <hr class="featurette-divider">

        <div class="row featurette">
            <div class="col-md-7">
                <h2 class="featurette-heading">Quem somos?</h2>
                <p class="lead">Na Fintech, nossa miss&atilde;o &eacute; simples: desde 2023, buscamos revolucionar a forma como as pessoas lidam com suas finan&ccedil;as. Somos pioneiros em oferecer solu&ccedil;&otilde;es pr&aacute;ticas e acess&iacute;veis para simplificar a administra&ccedil;&atilde;o financeira.</p>
            </div>
            <div class="col-md-5">
                <img class="featurette-image img-fluid mx-auto" src="resources/images/conteudo2.png" alt="Generic placeholder image">
            </div>
        </div>

        <hr class="featurette-divider">

        <div class="row featurette">
            <div class="col-md-7 order-md-2">
                <h2 class="featurette-heading">Como a Fintech <span class="text-muted">ir&aacute; facilitar a sua vida</span></h2>
                <p class="lead">Compreendemos que a vida moderna &eacute; acelerada, e &eacute; por isso que projetamos nosso site para proporcionar uma experi&ecirc;ncia de usu&aacute;rio intuitiva e de f&aacute;cil navega&ccedil;&atilde;o. Quer voc&ecirc; seja um especialista em finan&ccedil;as ou esteja apenas come&ccedil;ando sua jornada de planejamento financeiro, a Fintech est&aacute; aqui para simplificar e facilitar a gest&atilde;o do seu dinheiro.</p>
            </div>
            <div class="col-md-5 order-md-1">
                <img class="featurette-image img-fluid mx-auto" src="resources/images/conteudo3.png" alt="Generic placeholder image">
            </div>
        </div>

        <hr class="featurette-divider">

        <div class="row featurette">
            <div class="col-md-7">
                <h2 class="featurette-heading">Diga adeus aos relat&oacute;rios de despesas manuais e recibos perdidos</h2>
                <p class="lead">Simplificamos o gerenciamento de despesas, proporcionando uma experi&ecirc;ncia digital e sem complica&ccedil;&otilde;es. Nosso sistema intuitivo permite que voc&ecirc; acompanhe suas despesas de forma eficiente, eliminando a papelada e o estresse.</p>
            </div>
            <div class="col-md-5">
                <img class="featurette-image img-fluid mx-auto" src="resources/images/conteudo4.png" alt="Generic placeholder image">
            </div>
        </div>

        <hr class="featurette-divider">
   </div>     

    <footer class="container">
        <jsp:include page="footer.jsp" />
    </footer>
</main>

</body>
</html>

