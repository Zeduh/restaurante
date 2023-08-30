package br.com.joseduardo.restaurante.repository;

import br.com.joseduardo.restaurante.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {
}