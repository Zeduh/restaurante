package br.com.joseduardo.restaurante.controller;
import br.com.joseduardo.restaurante.dao.ClienteDao;
import br.com.joseduardo.restaurante.model.Cliente;
import br.com.joseduardo.restaurante.model.Endereco;
import br.com.joseduardo.restaurante.model.dto.ClienteInputDto;
import br.com.joseduardo.restaurante.model.dto.ClienteOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteDao clienteDao;

    @GetMapping("/form")
    public String form(){

        return "cliente/form";
    }

    @Transactional
    @PostMapping("/cadastra")
    public String cadastra(ClienteInputDto clienteInputDto){
        Cliente cliente = clienteInputDto.toCliente();
        this.clienteDao.cadastra(cliente);
        return "redirect:/cliente/lista";
    }

    @GetMapping("/lista")
    public String lista(Model model){
        model.addAttribute("clientes", this.clienteDao.lista().stream().map(cliente -> new ClienteOutputDto(cliente)).toList());
        return "cliente/clientes";
    }

    @Transactional
    @GetMapping("/desativa")
    public String desativa(@RequestParam("id") Integer id){
        Cliente cliente = this.clienteDao.buscarPor(id);
        cliente.setAtivo(false);
        return "redirect:/cliente/lista";
    }

    @GetMapping("/buscaEndereco")
    public String buscaEndereco(Integer id, Model model){
        Cliente cliente = this.clienteDao.buscarPor(id);
        List<Endereco> enderecos = cliente.getEnderecos();

        model.addAttribute("cliente", cliente);
        model.addAttribute("enderecos", enderecos);

        return "endereco/lista";
    }

}
