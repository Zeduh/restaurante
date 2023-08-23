package br.com.joseduardo.restaurante.model.dto;

import br.com.joseduardo.restaurante.model.Cliente;
import br.com.joseduardo.restaurante.model.Endereco;

public class EnderecoInputDto {
//    String cep, String rua, Integer id
    private Integer id;
    private String cep;
    private String rua;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Endereco toEndereco(Cliente cliente) {
        return new Endereco(this.cep, this.rua, cliente);
    }
}
