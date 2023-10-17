package br.com.joseduardo.restaurante.repository;

import br.com.joseduardo.restaurante.model.Funcionario;
import br.com.joseduardo.restaurante.model.projection.FuncionarioProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {

    @Query(
            value = "select * from funcionarios where nome = ? and email = ? and salario = ?",
            nativeQuery = true
    )
    List<Funcionario> findFuncionarios(String nome, String email, BigDecimal salario);

    @Query(value = "select nome, salario from funcionarios;", nativeQuery = true)
    List<FuncionarioProjection> findFuncionario();

}
