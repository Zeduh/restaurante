package br.com.joseduardo.restaurante.dao;

import br.com.joseduardo.restaurante.model.Produto;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ProdutoDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Cacheable("produtos")
    public List<Produto> lista(){
        return this.entityManager.createQuery("select p from Produto p", Produto.class).getResultList();
    }

    @CacheEvict(value="produtos", allEntries = true)
    public void cadastra(Produto produto) {
        this.entityManager.persist(produto);
    }

    public Produto buscaPorId(Integer id) { return this.entityManager.find(Produto.class, id); }

    @CacheEvict(value="produtos", allEntries = true)
    @Transactional
    public void deleta(Integer id){
        Produto produto = this.entityManager.find(Produto.class, id);
        this.entityManager.remove(produto);
    }

}