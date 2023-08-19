package br.com.joseduardo.restaurante.dao;

import br.com.joseduardo.restaurante.model.Produto;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ProdutoDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Produto> lista(){
        return this.entityManager.createQuery("select p from Produto p", Produto.class).getResultList();
    }

    public void cadastra(Produto produto) {
        this.entityManager.persist(produto);
    }

    public Produto buscaPorId(Integer id) { return this.entityManager.find(Produto.class, id); }
}