package br.com.joseduardo.restaurante.controller;
import Dao.ProdutoDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/produto")
public class ProdutoController {

    private ProdutoDao dao = new ProdutoDao();

    @GetMapping("/lista")
    public String lista(Model model){

        model.addAttribute("produtos", dao.lista());

        return "produtos";
    }

    @GetMapping("/form")
    public String form(){
        return "form";
    }

    @PostMapping("/cadastra")
    public void cadastra(){
        System.out.println("**** Metodo de cadastro");
    }

}
