package br.com.joseduardo.restaurante.controller;
import br.com.joseduardo.restaurante.model.Funcionario;
import br.com.joseduardo.restaurante.model.dto.FuncionarioAlteraInputDto;
import br.com.joseduardo.restaurante.model.dto.FuncionarioInputDto;
import br.com.joseduardo.restaurante.model.dto.FuncionarioOutputDto;
import br.com.joseduardo.restaurante.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository funcionarioDao;

    @Transactional
    @PostMapping
    public ResponseEntity cadastra(@RequestBody FuncionarioInputDto dto){
        Funcionario funcionario = dto.toFuncionario();
        funcionarioDao.save(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @GetMapping
    public List<FuncionarioOutputDto> lista(){
        List<Funcionario> funcionarios = this.funcionarioDao.findAll();
        List<FuncionarioOutputDto> funcionarioOutputDtoList = funcionarios.stream().map(funcionario -> new FuncionarioOutputDto(funcionario)).toList();
        return  funcionarioOutputDtoList;
    }

    @GetMapping("/{id}")
    public FuncionarioOutputDto buscaPor(@PathVariable Integer id){
        Funcionario funcionario = this.funcionarioDao.findById(id).get();
        FuncionarioOutputDto dto = new FuncionarioOutputDto(funcionario);
        return dto;
    }

    @Transactional
    @DeleteMapping("/{id}")
    public void deleta(@PathVariable Integer id){
        this.funcionarioDao.deleteById(id);
    }

    @Transactional
    @PutMapping
    public void altera(@RequestBody FuncionarioAlteraInputDto dto){
        Funcionario funcionario = this.funcionarioDao.findById(dto.getId()).get();
        funcionario.setEmail(dto.getEmail());
        funcionario.setSalario(dto.getSalario());
    }

}
