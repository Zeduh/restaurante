package model;

public enum Categoria {
    COMIDA("Comida"),
    BEBIDA("Bebida"),
    SOBREMESA("Sobremesa");

    private String descricao;

    private Categoria(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() { return descricao; }
}
