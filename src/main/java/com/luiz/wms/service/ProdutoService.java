package com.luiz.wms.service;

import com.luiz.wms.entity.Produto;
import com.luiz.wms.repository.ProdutoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    public Produto cadastrarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Produto buscarPorId(Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Produto não encontrado"
                        )
                );
    }

    public Produto atualizarProduto(Long id, Produto produto) {
        Produto produtoExistente = buscarPorId(id);

        produtoExistente.setNome(produto.getNome());
        produtoExistente.setDescricao(produto.getDescricao());
        produtoExistente.setPeso(produto.getPeso());
        produtoExistente.setQuantidade(produto.getQuantidade());
        produtoExistente.setSku(produto.getSku());

        return produtoRepository.save(produtoExistente);
    }
}
