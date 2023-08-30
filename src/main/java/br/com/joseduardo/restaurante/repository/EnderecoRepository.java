package br.com.joseduardo.restaurante.repository;

import br.com.joseduardo.restaurante.model.Endereco;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface EnderecoRepository extends Repository<Endereco, Integer> {
    void save(Endereco endereco);
    Optional<Endereco> findById(Integer id);
}
