package br.com.joseduardo.restaurante.controller;

import Dao.ProdutoDao;
import model.Categoria;
import model.Produto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {

    @GetMapping("/lista")
    public String lista(Model model){

        ProdutoDao dao = new ProdutoDao();
        List<Produto> produtos = dao.lista();

        model.addAttribute("produtos", produtos);

        return "produtos";
    }

}
