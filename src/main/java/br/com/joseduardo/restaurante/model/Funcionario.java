package br.com.joseduardo.restaurante.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "funcionarios")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private String email;

    private BigDecimal salario;

    @ManyToOne
    private Cargo cargo;

    public Funcionario(){}

    public Funcionario(String nome, String email, BigDecimal salario){
        this.nome = nome;
        this.email = email;
        this.salario = salario;
    }

    public Integer getId() { return id; }

    public String getNome() { return nome; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public BigDecimal getSalario() { return salario; }

    public void setSalario(BigDecimal salario) { this.salario = salario; }

    public Cargo getCargo() { return cargo; }

    public void setCargo(Cargo cargo) { this.cargo = cargo; }
}
