package br.com.joseduardo.restaurante.model;

public class ItemDeCompra {
    private Produto produto;
    private Integer quantidade;

    public ItemDeCompra(Produto produto, Integer quantidade){
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Produto getProduto() { return produto; }

    public Integer getQuantidade() { return quantidade; }

    @Override
    public String toString() {
        return "ItemDeCompra{" +
                "produto=" + produto +
                ", quantidade=" + quantidade +
                '}';
    }
}
