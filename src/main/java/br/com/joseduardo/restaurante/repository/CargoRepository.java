package br.com.joseduardo.restaurante.repository;

import br.com.joseduardo.restaurante.model.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CargoRepository extends JpaRepository<Cargo, Integer> {
}
