package br.com.joseduardo.restaurante.dao;

import br.com.joseduardo.restaurante.dao.mapper.ProdutoMapper;
import br.com.joseduardo.restaurante.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ProdutoDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PersistenceContext
    private EntityManager entityManager;

    public List<Produto> lista(){
        return this.jdbcTemplate.query("select * from produtos", new ProdutoMapper());
    }

    public void cadastra(Produto produto) {
        this.entityManager.persist(produto);
    }
}