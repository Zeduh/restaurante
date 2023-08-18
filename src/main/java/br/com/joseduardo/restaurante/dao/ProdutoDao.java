package br.com.joseduardo.restaurante.dao;

import br.com.joseduardo.restaurante.dao.mapper.ProdutoMapper;
import br.com.joseduardo.restaurante.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProdutoDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Produto> lista(){
        return this.jdbcTemplate.query("select * from produtos", new ProdutoMapper());
    }

    public void cadastra(Produto produto) {
        this.jdbcTemplate.update(
                "insert into produtos (nome, descricao, categoria, preco) values (?,?,?,?)",
                produto.getNome(),
                produto.getDescricao(),
                produto.getCategoria().getDescricao(),
                produto.getPreco()
        );
    }
}