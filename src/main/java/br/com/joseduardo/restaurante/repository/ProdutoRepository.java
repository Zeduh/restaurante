package br.com.joseduardo.restaurante.repository;

import br.com.joseduardo.restaurante.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository  extends JpaRepository<Produto, Integer> {
}
