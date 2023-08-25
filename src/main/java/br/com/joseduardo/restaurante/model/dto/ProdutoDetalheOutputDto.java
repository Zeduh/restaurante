package br.com.joseduardo.restaurante.model.dto;

import br.com.joseduardo.restaurante.model.Categoria;
import br.com.joseduardo.restaurante.model.Produto;

import java.math.BigDecimal;

public class ProdutoDetalheOutputDto {

    private Integer id;
    private String nome;
    private String descricao;
    private Categoria categoria;
    private BigDecimal preco;

    public ProdutoDetalheOutputDto(Produto produto){
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.descricao = produto.getDescricao();
        this.categoria = produto.getCategoria();
        this.preco = produto.getPreco();
    }

    public Integer getId() {
        return id;
    }

    public String getNome() { return nome; }

    public String getDescricao() { return descricao; }

    public Categoria getCategoria() { return categoria; }

    public BigDecimal getPreco() { return preco; }

    @Override
    public String toString() {
        return "ProdutoDetalheOutputDto{" +
                "id='" + id + '\'' +
                "nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", categoria=" + categoria +
                ", preco=" + preco +
                '}';
    }
}
