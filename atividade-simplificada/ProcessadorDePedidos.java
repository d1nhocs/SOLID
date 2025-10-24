class ProcessadorDePedidos {
    private final CalculadoraDeTotal calculadora;
    private final Map<String, PagamentoStrategy> metodosPagamento;
    private final RepositorioPedido repositorio;
    private final ServicoEmail servicoEmail;

    public ProcessadorDePedidos(
            CalculadoraDeTotal calculadora,
            Map<String, PagamentoStrategy> metodosPagamento,
            RepositorioPedido repositorio,
            ServicoEmail servicoEmail) {
        this.calculadora = calculadora;
        this.metodosPagamento = metodosPagamento;
        this.repositorio = repositorio;
        this.servicoEmail = servicoEmail;
    }

    public void processar(Pedido pedido) {
        double total = calculadora.calcularTotal(pedido);
        System.out.println("Total do pedido: " + total);

        PagamentoStrategy pagamento = metodosPagamento.get(pedido.getTipoPagamento());
        pagamento.processarPagamento(pedido, total);
        
        repositorio.salvar(pedido);
        servicoEmail.enviarConfirmacao(pedido);
    }
}