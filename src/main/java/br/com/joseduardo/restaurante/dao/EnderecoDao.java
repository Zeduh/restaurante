package br.com.joseduardo.restaurante.dao;

import br.com.joseduardo.restaurante.model.Cliente;
import br.com.joseduardo.restaurante.model.Endereco;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class EnderecoDao {

    @PersistenceContext
    private EntityManager em;

    public void cadastra(Endereco endereco){ this.em.persist(endereco); }


}
