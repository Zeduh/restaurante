package br.com.joseduardo.restaurante.controller;
import Dao.ProdutoDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

    private ProdutoDao dao = new ProdutoDao();

    @GetMapping("/lista")
    public String lista(Model model){

        model.addAttribute("produtos", dao.lista());

        return "produtos";
    }

}
