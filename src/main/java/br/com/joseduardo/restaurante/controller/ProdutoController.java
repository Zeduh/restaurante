package br.com.joseduardo.restaurante.controller;
import Dao.ProdutoDao;
import model.Categoria;
import model.Produto;
import model.dto.ProdutoFormImputDto;
import model.dto.ProdutoOutputDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/produto")
public class ProdutoController {

    private ProdutoDao dao = new ProdutoDao();

    @GetMapping("/lista")
    public String lista(Model model){
        List<ProdutoOutputDto> produtosDto = dao
                .lista()
                .stream()
                .map(produto -> new ProdutoOutputDto(produto))
                .collect(Collectors.toList());
        model.addAttribute("produtos", produtosDto);
        return "produtos";
    }

    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("categorias", Categoria.values());
        return "form";
    }

    @PostMapping("/cadastra")
    public String cadastra(ProdutoFormImputDto produtoFormImputDto, Model model){
        Produto produto = produtoFormImputDto.toProduto();
        this.dao.cadastra(produto);
        return lista(model);
    }

}
