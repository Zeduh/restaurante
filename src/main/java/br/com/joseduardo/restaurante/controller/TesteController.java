package br.com.joseduardo.restaurante.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TesteController {

    @GetMapping("/search")
    public String pesquisa(
            @RequestParam("idDoProduto") int id,
            @RequestParam(value = "nomeDoProduto", required = false) String nome
    ){
        System.out.println("*** CHEGOU NA CONTROLLER TESTE: " + id + " - " + nome);

        return "teste";
    }
}
