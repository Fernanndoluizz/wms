package com.luiz.wms.controller;

import com.luiz.wms.entity.Produto;
import com.luiz.wms.service.ProdutoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService){
        this.produtoService = produtoService;
    }

    @GetMapping
    public List<Produto> listarTodos(){
        return produtoService.listarTodos();
    }

    @PostMapping
    public Produto cadastrarProduto(@RequestBody Produto produto){
        return produtoService.cadastrarProduto(produto);

    }

    @GetMapping("/{id}")
    public Produto buscarPorId(@PathVariable Long id) {
        return produtoService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Produto atualizarProduto(@PathVariable Long id, @RequestBody Produto produto) {
        return produtoService.atualizarProduto(id, produto);
    }

    

}
