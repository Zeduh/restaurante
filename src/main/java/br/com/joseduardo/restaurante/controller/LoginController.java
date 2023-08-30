package br.com.joseduardo.restaurante.controller;
import br.com.joseduardo.restaurante.model.Cliente;
import br.com.joseduardo.restaurante.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private ClienteRepository clienteDao;

    @GetMapping
    public String form(){
        return "login/form";
    }

    @PostMapping("/login")
    public String login(String email, String senha, RedirectAttributes redirectAttributes, HttpSession session){
        Cliente cliente = this.clienteDao.findByEmailAndSenha(email, senha);

        if(cliente == null){
            redirectAttributes.addFlashAttribute("usuarioInvalido", "Usuário Inválido");
            return "redirect:/";
        }

        session.setAttribute("logado", cliente);


        return "redirect:/produto/lista";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }
}
