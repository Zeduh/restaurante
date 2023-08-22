package br.com.joseduardo.restaurante.model;

import javax.persistence.*;

@Entity
@Table(name = "enderecos")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String cep;

    private String rua;

    @ManyToOne
    private Cliente cliente;

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getCep() { return cep; }

    public void setCep(String cep) { this.cep = cep; }

    public String getRua() { return rua; }

    public void setRua(String rua) { this.rua = rua; }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
