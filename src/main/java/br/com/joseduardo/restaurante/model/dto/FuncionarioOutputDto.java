package br.com.joseduardo.restaurante.model.dto;

import br.com.joseduardo.restaurante.model.Funcionario;

import java.math.BigDecimal;

public class FuncionarioOutputDto {

    private String nome;
    private BigDecimal salario;

    public FuncionarioOutputDto(Funcionario funcionario){
        this.nome = funcionario.getNome();
        this.salario = funcionario.getSalario();
    }




    public String getNome() { return nome; }

    public BigDecimal getSalario() { return salario; }

}
