package br.com.joseduardo.restaurante.model;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
@SessionScope
public class Carrinho {

    private List<ItemDeCompra> compras = new ArrayList<>();

    public void add(ItemDeCompra item){
        this.compras.add(item);
    }

    public List<ItemDeCompra> getCompras(){
        return Collections.unmodifiableList(this.compras);
    }

}
