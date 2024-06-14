// função para redirecionar a opção de cadastro para a servelet correta    
    
    document.getElementById('transactionForm').addEventListener('submit', function(event) {
        event.preventDefault(); // Impede o envio padrão do formulário

        var tipo = document.getElementById('tipo').value;
        var actionUrl;

        switch(tipo) {
            case 'Receita':
                actionUrl = 'DepositoServlet';
                break;
            case 'Despesa':
                actionUrl = 'DespesaServlet';
                break;
            case 'Pagamento recorrente':
                actionUrl = 'PagamentoRecorrenteServlet';
                break;            
        }

        this.action = actionUrl;
        this.method = 'post';
        this.submit(); 
    });

