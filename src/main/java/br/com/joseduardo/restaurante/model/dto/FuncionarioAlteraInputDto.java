package br.com.joseduardo.restaurante.model.dto;

import java.math.BigDecimal;

public class FuncionarioAlteraInputDto {

    private Integer id;
    private String email;
    private BigDecimal salario;

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public BigDecimal getSalario() { return salario; }

    public void setSalario(BigDecimal salario) { this.salario = salario; }

}
