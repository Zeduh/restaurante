package br.com.joseduardo.restaurante.dao;

import br.com.joseduardo.restaurante.model.Cliente;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ClienteDao {
    @PersistenceContext
    private EntityManager em;

    public void cadastra(Cliente cliente){ this.em.persist(cliente); }

    public List<Cliente> lista(){ return this.em.createQuery("select c from Cliente c", Cliente.class).getResultList(); }

    public Cliente buscarPor(Integer id){ return this.em.find(Cliente.class, id); }

    public Cliente existe(String email, String senha) {
        String jpql = "select c from Cliente c WHERE c.email = :email AND c.senha = :senha";

        try{
            return this.em.createQuery(jpql, Cliente.class)
                    .setParameter("email", email)
                    .setParameter("senha", senha)
                    .getSingleResult();
        } catch (NoResultException ex){
            return null;
        }
    }
}
