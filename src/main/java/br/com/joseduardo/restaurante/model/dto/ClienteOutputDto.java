package br.com.joseduardo.restaurante.model.dto;

import br.com.joseduardo.restaurante.model.Cliente;

public class ClienteOutputDto {
    private Integer id;
    private String nome;
    private String email;
    private boolean ativo;

    public ClienteOutputDto(Cliente cliente){
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.email = cliente.getEmail();
        this.ativo = cliente.getAtivo();
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public boolean isAtivo() {
        return ativo;
    }
}
