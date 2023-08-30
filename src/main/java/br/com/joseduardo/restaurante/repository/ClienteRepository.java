package br.com.joseduardo.restaurante.repository;

import br.com.joseduardo.restaurante.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    Cliente findByEmailAndSenha(String email, String senha);

}
