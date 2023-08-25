package br.com.joseduardo.restaurante.controller;

import br.com.joseduardo.restaurante.dao.ProdutoDao;
import br.com.joseduardo.restaurante.model.Carrinho;
import br.com.joseduardo.restaurante.model.ItemDeCompra;
import br.com.joseduardo.restaurante.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/carrinho")
public class CarrinhoController {

    @Autowired
    private ProdutoDao produtoDao;

    @Autowired
    private Carrinho carrinho;

    @PostMapping("/add")
    public  String add(Integer idProduto, Integer quantidade){
        Produto produto = this.produtoDao.buscaPorId(idProduto);
        ItemDeCompra itemDeCompra = new ItemDeCompra(produto, quantidade);
        this.carrinho.add(itemDeCompra);

        //carrinho de compras

        return "redirect:/produto/lista";
    }

    @GetMapping("/total")
    public  void  total(){
        this.carrinho.getCompras().forEach(compra -> System.out.println(compra));
    }

}
