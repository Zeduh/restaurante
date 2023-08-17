package br.com.joseduardo.restaurante.controller;

import model.ProdutoSimples;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(Model model){

        model.addAttribute("produtos",
                Arrays.asList(
                        new ProdutoSimples(1, "celular", BigDecimal.TEN, true),
                        new ProdutoSimples(2, null, new BigDecimal(20), true),
                        new ProdutoSimples(3, "Video Game", BigDecimal.ONE, false)
                )
        );

        return "hello";
    }

}
