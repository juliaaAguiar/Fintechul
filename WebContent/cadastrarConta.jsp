<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
</head>
<body>
    <header>
        <jsp:include page="header.jsp" />
    </header>

    <h1 class="text" style="color: black; text-align: center; margin-top: 80px;">Cadastrar Conta</h1>
    <div class="container-fluid mt-4">
        <div class="row justify-content-center">
            <div class="col-md-6 mb-4 text-center" style="display: flex; justify-content: center;">
                <div class="card" style="margin: 0; border: none;">
                    <div class="card-body">
                        <img src="resources/images/cartaoConta1.png" alt="Imagem do Cartão" class="img-fluid mb-3">
                        <form action="url action aqui" method="post">
                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label for="nome">Nome:</label>
                                    <input type="text" id="nome" name="nome" class="form-control">
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="agencia">Agência:</label>
                                    <input type="text" id="agencia" name="agencia" class="form-control">
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label for="numero">Número:</label>
                                    <input type="text" id="numero" name="numero" class="form-control">
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label for="saldo">Saldo:</label>
                                    <input type="text" id="saldo" name="saldo" class="form-control">
                                </div>
                            </div>
                            <div class="form-group">
                                <input type="submit" value="Salvar" class="btn btn-primary">
                                <a href="despesa?acao=listar" class="btn btn-danger">Cancelar</a>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <footer class="container">
        <jsp:include page="footer.jsp" />
    </footer>
  
</body>
</html>
