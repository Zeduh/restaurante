package br.com.joseduardo.restaurante.model;

import java.util.Objects;

public class ItemDeCompra {
    private Produto produto;
    private Integer quantidade;

    public ItemDeCompra(Produto produto, Integer quantidade){
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Produto getProduto() { return produto; }

    public Integer getQuantidade() { return quantidade; }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "ItemDeCompra{" +
                "produto=" + produto +
                ", quantidade=" + quantidade +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemDeCompra that = (ItemDeCompra) o;
        return Objects.equals(produto, that.produto) && Objects.equals(quantidade, that.quantidade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(produto, quantidade);
    }
}
