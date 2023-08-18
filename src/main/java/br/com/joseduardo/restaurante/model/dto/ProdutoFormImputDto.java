package br.com.joseduardo.restaurante.model.dto;
import br.com.joseduardo.restaurante.model.Categoria;
import br.com.joseduardo.restaurante.model.Produto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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

    @NotBlank(message = "O Campo nome deve ser preenchido")
    public String getNome() {
        return nome;
    }

    @NotBlank(message = "O campo descrição deve ser preenchido")
    public String getDescricao() {
        return descricao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    @NotNull(message = "O campo preço deve ser preenchido")
    @Min(message = "O preço deve ser maior que 5", value = 5)
    public BigDecimal getPreco() {
        return preco;
    }

    public Produto toProduto() {
        return new Produto(this.id, this.nome,this.descricao, this.categoria, this.preco);
    }
}
