package br.com.joseduardo.restaurante.repository;

import br.com.joseduardo.restaurante.model.Funcionario;
import br.com.joseduardo.restaurante.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProdutoRepository  extends JpaRepository<Produto, Integer> {
}
