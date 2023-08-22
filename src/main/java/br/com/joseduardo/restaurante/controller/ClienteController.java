package br.com.joseduardo.restaurante.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

    @GetMapping("/cliente/form")
    public String form(){
        return "form";
    }
}
