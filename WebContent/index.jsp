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

    <title>Fintech</title>

    <!-- Bootstrap CSS principal -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" 
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    <!-- Estilos personalizados -->
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
              <div class="carousel-caption text-left">
                <h1>Simplifique suas finanças com a Fintech.</h1>
                <p>Simplificamos suas finanças para que você possa focar no que realmente importa.</p>
              </div>
            </div>
          </div>
          <div class="carousel-item">
            <img class="second-slide" src="resources/images/simpli.jpg" class="responsive" alt="Second slide">
            <div class="container">
              <div class="carousel-caption">
                <h1>Aqui organize de forma facil sua vida financeira.</h1>
                <p>Organize sua vida financeira de forma simples e eficaz aqui na Fintech! Nossa plataforma intuitiva e ferramentas poderosas facilitam o controle dos seus recursos.</p>
              </div>
            </div>
          </div>
          <div class="carousel-item">
            <img class="third-slide" src="resources/images/investimento.jpg" class="responsive" alt="Third slide">
            <div class="container">
              <div class="carousel-caption text-right">
                <h1>Explore oportunidades de investimento na nossa plataforma!.</h1>
                <p>Deixe seu dinheiro trabalhar para você enquanto você foca no que é importante.</p>
              </div>
            </div>
          </div>
        </div>
        <a class="carousel-control-prev" href="#myCarousel" role="button" data-slide="prev">
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#myCarousel" role="button" data-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="sr-only">Next</span>
        </a>
      </div>

      <!-- Marketing messaging and featurettes -->
      <!-- Wrap the rest of the page in another container to center all the content. -->

      <div class="container marketing">

        <!-- Three columns of text below the carousel -->
        <div class="row">
          <div class="col-lg-4">
            <img class="rounded-circle" src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" alt="Generic placeholder image" width="140" height="140">
            <h2>Texto</h2>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
            <p><a class="btn btn-secondary" href="#" role="button">View details »</a></p>
          </div><!-- /.col-lg-4 -->
          <div class="col-lg-4">
            <img class="rounded-circle" src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" alt="Generic placeholder image" width="140" height="140">
            <h2>Texto</h2>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
            <p><a class="btn btn-secondary" href="#" role="button">View details »</a></p>
          </div><!-- /.col-lg-4 -->
          <div class="col-lg-4">
            <img class="rounded-circle" src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" alt="Generic placeholder image" width="140" height="140">
            <h2>Texto</h2>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
            <p><a class="btn btn-secondary" href="#" role="button">View details »</a></p>
          </div><!-- /.col-lg-4 -->
        </div><!-- /.row -->

        <!-- START THE FEATURETTES -->

        <hr class="featurette-divider">

        <div class="row featurette">
          <div class="col-md-7">
            <h2 class="featurette-heading">Quem somos?</h2>
            <p class="lead">Na Fintech, nossa missão é simples: desde 2023, buscamos revolucionar a forma como as pessoas lidam com suas finanças. Somos pioneiros em oferecer soluções práticas e acessíveis para simplificar a administração financeira.</p>
          </div>
          <div class="col-md-5">
            <img class="featurette-image img-fluid mx-auto" src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" alt="Generic placeholder image">
          </div>
        </div>

        <hr class="featurette-divider">

        <div class="row featurette">
          <div class="col-md-7 order-md-2">
            <h2 class="featurette-heading">Como a Fintech <span class="text-muted">irá facilitar a sua vida</span></h2>
            <p class="lead">Compreendemos que a vida moderna é acelerada, e é por isso que projetamos nosso site para proporcionar uma experiência de usuário intuitiva e de fácil navegação. Quer você seja um especialista em finanças ou esteja apenas começando sua jornada de planejamento financeiro, a Fintech está aqui para simplificar e facilitar a gestão do seu dinheiro.</p>
          </div>
          <div class="col-md-5 order-md-1">
            <img class="featurette-image img-fluid mx-auto" src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" alt="Generic placeholder image">
          </div>
        </div>

        <hr class="featurette-divider">

        <div class="row featurette">
          <div class="col-md-7">
            <h2 class="featurette-heading">Diga adeus aos relatórios de despesas manuais e recibos perdidos</h2>
            <p class="lead">simplificamos o gerenciamento de despesas, proporcionando uma experiência digital e sem complicações. Nosso sistema intuitivo permite que você acompanhe suas despesas de forma eficiente, eliminando a papelada e o estresse.</p>
          </div>
          <div class="col-md-5">
            <img class="featurette-image img-fluid mx-auto" src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" alt="Generic placeholder image">
          </div>
        </div>

        <hr class="featurette-divider">

        <!-- /END THE FEATURETTES -->

      </div><!-- /.container -->

      <!-- FOOTER -->
      <footer class="container">
        <p class="float-right"><a href="#">Voltar ao topo</a></p>
        <p>&copy; © 2024 Fintech. Todos os direitos reservados. &middot;</p>
      </footer>
    </main>

    <!-- Bootstrap core JavaScript -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" 
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" 
            integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBkE4ABXtW80PAK8Fn27lB60v7Y5NJvcs1k5i+l0D" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" 
            integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
  </body>
</html>
