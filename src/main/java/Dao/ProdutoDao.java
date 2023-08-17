package Dao;

import model.Categoria;
import model.Produto;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProdutoDao {

    private static List<Produto> produtos = new ArrayList<>();

    public List<Produto> lista(){
        produtos.clear();
        produtos.add(new Produto(1, "salada", "Salada de alface e tomate", Categoria.COMIDA, BigDecimal.TEN));
        produtos.add(new Produto(2, "Frango grelhado", "Acompanha arroz", Categoria.COMIDA, BigDecimal.ONE));
        produtos.add(new Produto(3, "Refrigerante", "Agua tônica sem açucar", Categoria.COMIDA, BigDecimal.ZERO));
        produtos.add(new Produto(3, "Brigadeiro", "Brigadeiro de colher", Categoria.SOBREMESA, BigDecimal.ZERO));

        return produtos;
    }



}