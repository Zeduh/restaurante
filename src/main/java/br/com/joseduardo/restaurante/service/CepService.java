package br.com.joseduardo.restaurante.service;

import br.com.joseduardo.restaurante.model.dto.EnderecoJsonDto;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CepService {


    public String getRua(String cep) {
        String url = "https://viacep.com.br/ws/" + cep + "/json";
        return new RestTemplate().getForObject(url, EnderecoJsonDto.class).getLogradouro();
    }
}
