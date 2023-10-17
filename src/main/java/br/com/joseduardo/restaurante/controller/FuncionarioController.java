package br.com.joseduardo.restaurante.controller;
import br.com.joseduardo.restaurante.model.Cargo;
import br.com.joseduardo.restaurante.model.Funcionario;
import br.com.joseduardo.restaurante.model.dto.FuncionarioAlteraInputDto;
import br.com.joseduardo.restaurante.model.dto.FuncionarioInputDto;
import br.com.joseduardo.restaurante.model.dto.FuncionarioOutputDto;
import br.com.joseduardo.restaurante.model.projection.FuncionarioProjection;
import br.com.joseduardo.restaurante.repository.CargoRepository;
import br.com.joseduardo.restaurante.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository funcionarioDao;

    @Autowired
    private CargoRepository cargoRepository;

    @Transactional
    @PostMapping
    public ResponseEntity cadastra(@RequestBody FuncionarioInputDto dto){
        Cargo cargo = this.cargoRepository.getReferenceById(dto.getCargoId());
        Funcionario funcionario = dto.toFuncionario();
        funcionario.setCargo(cargo);
        funcionarioDao.save(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @GetMapping("/pagina")
    public Page<Funcionario> listaOrdenada(@PageableDefault(page = 0, size = 5) Pageable pageable){
        return this.funcionarioDao.findAll(pageable);
    }

    @GetMapping
    public List<FuncionarioProjection> lista(){
        return this.funcionarioDao.findFuncionario();
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
