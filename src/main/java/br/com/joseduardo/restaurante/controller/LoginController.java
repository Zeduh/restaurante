package br.com.joseduardo.restaurante.controller;

import br.com.joseduardo.restaurante.dao.ClienteDao;
import br.com.joseduardo.restaurante.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

    @Autowired
    private ClienteDao clienteDao;

    @GetMapping
    public String form(){
        return "login/form";
    }

    @PostMapping("/login")
    public String login(String email, String senha, RedirectAttributes redirectAttributes){
        Cliente cliente = this.clienteDao.existe(email, senha);

        if(cliente == null){
            redirectAttributes.addFlashAttribute("usuarioInvalido", "Usuário Inválido");
            return "redirect:/";
        }

        System.out.println(cliente);
        return "redirect:/produto/lista";
    }
}
