<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

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
                            <th>Aquisi��o</th>
                            <th>Tipo</th>
                            <th>Quantidade</th>
                            <th>Valor Ind.</th>
                            <th>Valor Inv.</th>
                            <th>Alterar</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
<!--                             bot�o -->
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
                                Fundos Imobili�rios
                                <span class="badge badge-primary badge-pill">16,30%</span>
                            </li>
                            <li class="list-group-item d-flex justify-content-between align-items-center">
                                Tesouro Direto
                                <span class="badge badge-primary badge-pill">16,30%</span>
                            </li>
                            <li class="list-group-item d-flex justify-content-between align-items-center">
                                A��es
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

</body>

</html>
	