package model.dto;

import model.Categoria;
import model.Produto;

import java.math.BigDecimal;

public class ProdutoFormImputDto {

    private Integer id;
    private String nome;
    private String descricao;
    private Categoria categoria;
    private BigDecimal preco;

    public ProdutoFormImputDto(Integer id, String nome, String descricao, Categoria categoria, BigDecimal preco) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.categoria = categoria;
        this.preco = preco;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Produto toProduto() {
        return new Produto(this.id, this.nome,this.descricao, this.categoria, this.preco);
    }
}
