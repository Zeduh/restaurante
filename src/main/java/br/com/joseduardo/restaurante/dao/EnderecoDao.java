package br.com.joseduardo.restaurante.dao;

import br.com.joseduardo.restaurante.model.Endereco;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class EnderecoDao {

    @PersistenceContext
    private EntityManager em;

    public void cadastra(Endereco endereco){ this.em.persist(endereco); }

}
