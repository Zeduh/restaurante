package br.com.joseduardo.restaurante.model;

public enum Categoria {
    COMIDA("Comida"),
    BEBIDA("Bebida"),
    SOBREMESA("Sobremesa");

    private String descricao;

    Categoria(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() { return descricao; }
}
