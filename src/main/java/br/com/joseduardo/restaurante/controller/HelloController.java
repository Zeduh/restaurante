package br.com.joseduardo.restaurante.controller;

import model.ProdutoSimples;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(Model model){

        model.addAttribute("produtos",
                Arrays.asList(
                        new ProdutoSimples(1, "celular", BigDecimal.TEN, true, LocalDate.now()),
                        new ProdutoSimples(2, null, new BigDecimal(20), true, LocalDate.of(2023, 4,10)),
                        new ProdutoSimples(3, "Video Game", BigDecimal.ONE, false, LocalDate.of(2025,10,10))
                )
        );

        return "hello";
    }

}
