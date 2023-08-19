package br.com.joseduardo.restaurante.controller;
import br.com.joseduardo.restaurante.dao.ProdutoDao;
import br.com.joseduardo.restaurante.model.Categoria;
import br.com.joseduardo.restaurante.model.Produto;
import br.com.joseduardo.restaurante.model.dto.ProdutoALteraInputDto;
import br.com.joseduardo.restaurante.model.dto.ProdutoDetalheOutputDto;
import br.com.joseduardo.restaurante.model.dto.ProdutoFormImputDto;
import br.com.joseduardo.restaurante.model.dto.ProdutoOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoDao dao;

    @GetMapping("/lista")
    public String lista(Model model){
        List<ProdutoOutputDto> produtosDto = dao
                .lista()
                .stream()
                .map(ProdutoOutputDto::new)
                .collect(Collectors.toList());
        model.addAttribute("produtos", produtosDto);
        return "produtos";
    }

    @GetMapping("/form")
    public String form(Model model, ProdutoFormImputDto produtoFormImputDto) {
        model.addAttribute("categorias", Categoria.values());
        model.addAttribute("produtoFormImputDto", produtoFormImputDto);
        return "form";
    }

    @Transactional
    @PostMapping("/cadastra")
    public String cadastra(@Valid ProdutoFormImputDto produtoFormImputDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model){
        if(bindingResult.hasErrors())
            return form(model, produtoFormImputDto);

        Produto produto = produtoFormImputDto.toProduto();
        this.dao.cadastra(produto);
        redirectAttributes.addFlashAttribute("sucesso", "Produto cadastrado com sucesso!");
        return "redirect:/produto/lista";
    }

    @GetMapping("/detalhe/{id}")
    public String detalhe(@PathVariable Integer id, Model model){
        model.addAttribute("produto", new ProdutoDetalheOutputDto(this.dao.buscaPorId(id)));
        return "detalhe";
    }

    @GetMapping("/deleta")
    public String deleta(@RequestParam("id") Integer id, RedirectAttributes redirectAttributes){
        this.dao.deleta(id);
        redirectAttributes.addFlashAttribute("sucesso", "Produto deletado com sucesso!");
        return "redirect:/produto/lista";
    }

    @GetMapping("/preparaAltera")
    public String preparaAltera(@RequestParam("id") Integer id, Model model){
        model.addAttribute("produto", this.dao.buscaPorId(id));
        model.addAttribute("categorias", Categoria.values());
        return "form-altera";
    }

    @Transactional
    @PostMapping("/atualiza")
    public String atualiza(ProdutoALteraInputDto dto, RedirectAttributes redirectAttributes){
        Produto produto = this.dao.buscaPorId(dto.getId());
        produto.setNome(dto.getNome());
        produto.setDescricao((dto.getDescricao()));
        produto.setCategoria(dto.getCategoria());
        produto.setPreco(dto.getPreco());
        redirectAttributes.addFlashAttribute("sucesso", "Produto alterado com sucesso!");
        return ("redirect:/produto/lista");
    }
}
