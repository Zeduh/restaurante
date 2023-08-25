package br.com.joseduardo.restaurante.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String descricao;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;
    private BigDecimal preco;

    public Produto(){}

    public Produto(Integer id, String nome, String descricao, Categoria categoria, BigDecimal preco) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.categoria = categoria;
        this.preco = preco;
    }

    public Integer getId() { return id; }

    public String getNome() { return nome; }

    public String getDescricao() { return descricao; }

    public Categoria getCategoria() { return categoria; }

    public BigDecimal getPreco() { return preco; }

    public void setNome(String nome) { this.nome = nome; }

    public void setDescricao(String descricao) { this.descricao = descricao; }

    public void setCategoria(Categoria categoria) { this.categoria = categoria; }

    public void setPreco(BigDecimal preco) { this.preco = preco; }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", categoria=" + categoria +
                ", preco=" + preco +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(id, produto.id) && Objects.equals(nome, produto.nome) && Objects.equals(descricao, produto.descricao) && categoria == produto.categoria && Objects.equals(preco, produto.preco);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, descricao, categoria, preco);
    }
}
