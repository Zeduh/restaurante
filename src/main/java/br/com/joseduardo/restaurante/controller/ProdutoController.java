package br.com.joseduardo.restaurante.controller;
import Dao.ProdutoDao;
import model.Categoria;
import model.Produto;
import model.dto.ProdutoFormImputDto;
import model.dto.ProdutoOutputDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/produto")
public class ProdutoController {

    private ProdutoDao dao = new ProdutoDao();

    @GetMapping("/lista")
    public String lista(Model model){
        List<ProdutoOutputDto> produtosDto = dao
                .lista()
                .stream()
                .map(produto -> new ProdutoOutputDto(produto))
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

    @PostMapping("/cadastra")
    public String cadastra(@Valid ProdutoFormImputDto produtoFormImputDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model){
        if(bindingResult.hasErrors())
            return form(model, produtoFormImputDto);

        Produto produto = produtoFormImputDto.toProduto();
        this.dao.cadastra(produto);
        redirectAttributes.addFlashAttribute("sucesso", "Produto cadastrado com sucesso!");
        return "redirect:/produto/lista";
    }

}
