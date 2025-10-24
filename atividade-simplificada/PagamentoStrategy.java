interface PagamentoStrategy {
    void processarPagamento(Pedido pedido, double total);
}