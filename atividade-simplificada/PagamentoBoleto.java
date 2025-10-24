class PagamentoBoleto implements PagamentoStrategy {
    public void processarPagamento(Pedido pedido, double total) {
        System.out.println("Gerando boleto bancário. Total: " + total);
    }
}