package model.dto;

import model.Produto;

import java.math.BigDecimal;

public class ProdutoOutputDto {

    private Integer id;
    private String nome;
    private BigDecimal preco;

    public ProdutoOutputDto(Produto produto) {
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.preco = produto.getPreco();
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }
}
