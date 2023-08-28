package br.com.joseduardo.restaurante.dao;

import br.com.joseduardo.restaurante.model.Funcionario;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class FuncionarioDao {

    @PersistenceContext
    private EntityManager em;

    public void cadastra(Funcionario funcionario){
        this.em.persist(funcionario);
    }

    public List<Funcionario> lista(){
        return this.em.createQuery("select f from Funcionario f", Funcionario.class).getResultList();
    }

    public Funcionario buscaPor(Integer id) {
        return this.em.find(Funcionario.class, id);
    }

    public void remove(Integer id){
        Funcionario funcionario = this.em.find(Funcionario.class, id);
        this.em.remove(funcionario);
    }

}
