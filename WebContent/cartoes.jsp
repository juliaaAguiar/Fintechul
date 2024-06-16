<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
                </div>
            </div>
        </div>
    </div>
    <footer class="container">
        <jsp:include page="footer.jsp" />
    </footer>

  
</body>
</html>
