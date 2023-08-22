package br.com.joseduardo.restaurante.controller;

import br.com.joseduardo.restaurante.dao.ClienteDao;
import br.com.joseduardo.restaurante.model.Cliente;
import br.com.joseduardo.restaurante.model.dto.ClienteInputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
        return null;
    }
}
