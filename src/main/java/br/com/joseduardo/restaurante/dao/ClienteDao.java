package br.com.joseduardo.restaurante.dao;

import br.com.joseduardo.restaurante.model.Cliente;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class ClienteDao {
    @PersistenceContext
    private EntityManager em;

    public void cadastra(Cliente cliente){ this.em.persist(cliente); }
}
