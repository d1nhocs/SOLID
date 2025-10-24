class PagamentoCartao implements PagamentoStrategy {
    public void processarPagamento(Pedido pedido, double total) {
        System.out.println("Processando pagamento via Cartão de Crédito. Total: " + total);
    }
}