class CalculadoraDeTotal {
    public double calcularTotal(Pedido pedido) {
        return pedido.getItens().stream()
                .mapToDouble(Item::getPreco)
                .sum();
    }
}