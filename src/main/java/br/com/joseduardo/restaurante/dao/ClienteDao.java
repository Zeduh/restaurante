package br.com.joseduardo.restaurante.dao;

import br.com.joseduardo.restaurante.model.Cliente;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ClienteDao {
    @PersistenceContext
    private EntityManager em;

    public void cadastra(Cliente cliente){ this.em.persist(cliente); }

    public List<Cliente> lista(){ return this.em.createQuery("select c from Cliente c", Cliente.class).getResultList(); }

    public Cliente buscarPor(Integer id){ return this.em.find(Cliente.class, id); }
}
