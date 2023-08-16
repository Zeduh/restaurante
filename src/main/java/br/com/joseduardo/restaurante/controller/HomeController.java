package br.com.joseduardo.restaurante.controller;

import model.Categoria;
import model.Produto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.Arrays;

@Controller
@RequestMapping("/home")
public class HomeController {

    @GetMapping
    public ModelAndView home(){

        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("produto", new Produto(
                1,
                "salada",
                "Salada de alface e tomate",
                Categoria.COMIDA,
                BigDecimal.TEN
        ));

        return modelAndView;
    }

    @GetMapping("/lista")
    public String lista(Model model){
        Produto p1 = new Produto(1, "salada", "Salada de alface e tomate", Categoria.COMIDA, BigDecimal.TEN);
        Produto p2 = new Produto(2, "Frango grelhado", "Acompanha arroz", Categoria.COMIDA, BigDecimal.ONE);
        Produto p3 = new Produto(3, "Refrigerante", "Agua tônica sem açucar", Categoria.COMIDA, BigDecimal.ZERO);
        Produto p4 = new Produto(3, "Brigadeiro", "Brigadeiro de colher", Categoria.SOBREMESA, BigDecimal.ZERO);


        model.addAttribute("produtos", Arrays.asList(p1, p2, p3, p4));

        System.out.println(Arrays.asList(p1, p2, p3));

        return "produtos";
    }

}
