package br.com.joseduardo.restaurante.controller;
import br.com.joseduardo.restaurante.model.Cliente;
import br.com.joseduardo.restaurante.model.Endereco;
import br.com.joseduardo.restaurante.model.dto.EnderecoInputDto;
import br.com.joseduardo.restaurante.repository.ClienteRepository;
import br.com.joseduardo.restaurante.repository.EnderecoRepository;
import br.com.joseduardo.restaurante.service.CepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private ClienteRepository clienteDao;

    @Autowired
    private EnderecoRepository enderecoDao;

    @Autowired
    private CepService cepService;

    @GetMapping("/formCep")
    public String formCep(@RequestParam("id") Integer idCliente, Model model){
        model.addAttribute("cliente", idCliente);
        return "endereco/formCep";
    }

    @GetMapping("/pesquisa")
    public  String pesquisa(Integer id, String cep, Model model){
        model.addAttribute("cliente", clienteDao.findById(id).get());
        model.addAttribute("cep", cep);
        model.addAttribute("rua", this.cepService.getRua(cep));
        return "endereco/form";
    }

    @Transactional
    @PostMapping("/cadastra")
    public String cadastra(EnderecoInputDto enderecoInputDto){
        Cliente cliente = this.clienteDao.findById(enderecoInputDto.getId()).get();
        Endereco endereco = enderecoInputDto.toEndereco(cliente);

        this.enderecoDao.save(endereco);
        cliente.adiciona(endereco);
        return "redirect:/cliente/lista";
    }
}
