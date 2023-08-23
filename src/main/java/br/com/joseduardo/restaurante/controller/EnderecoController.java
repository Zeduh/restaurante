package br.com.joseduardo.restaurante.controller;

import br.com.joseduardo.restaurante.dao.ClienteDao;
import br.com.joseduardo.restaurante.dao.EnderecoDao;
import br.com.joseduardo.restaurante.model.Cliente;
import br.com.joseduardo.restaurante.model.Endereco;
import br.com.joseduardo.restaurante.model.dto.EnderecoInputDto;
import br.com.joseduardo.restaurante.model.dto.EnderecoJsonDto;
import br.com.joseduardo.restaurante.service.CepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private ClienteDao clienteDao;

    @Autowired
    private EnderecoDao enderecoDao;

    @Autowired
    private CepService cepService;

    @GetMapping("/formCep")
    public String formCep(@RequestParam("id") Integer idCliente, Model model){
        model.addAttribute("cliente", idCliente);
        return "endereco/formCep";
    }

    @GetMapping("/pesquisa")
    public  String pesquisa(Integer id, String cep, Model model){
        model.addAttribute("cliente", clienteDao.buscarPor(id));
        model.addAttribute("cep", cep);
        model.addAttribute("rua", this.cepService.getRua(cep));
        return "endereco/form";
    }

    @Transactional
    @PostMapping("/cadastra")
    public String cadastra(EnderecoInputDto enderecoInputDto){
        Cliente cliente = this.clienteDao.buscarPor(enderecoInputDto.getId());
        Endereco endereco = enderecoInputDto.toEndereco(cliente);

        this.enderecoDao.cadastra(endereco);
        cliente.adiciona(endereco);
        return "redirect:/cliente/lista";
    }
}
