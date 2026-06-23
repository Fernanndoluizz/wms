package com.luiz.wms.controller;


import com.luiz.wms.entity.Localizacao;
import com.luiz.wms.service.LocalizacaoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/localizacoes")
public class LocalizacaoController {

    private final LocalizacaoService localizacaoService;

    public LocalizacaoController(LocalizacaoService localizacaoService) {
        this.localizacaoService = localizacaoService;
    }

    @GetMapping
    public List<Localizacao> listarTodos() {
        return localizacaoService.listarTodos();
    }

    @PostMapping
    public Localizacao cadastrarLocalizacao(@Valid @RequestBody Localizacao localizacao){
        return localizacaoService.cadastrarLocalizacao(localizacao);
    }

    @GetMapping("/{id}")
    public Localizacao buscarPorId(@PathVariable Long id){
        return localizacaoService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Localizacao atualizarLocalizacao(@PathVariable Long id, @Valid @RequestBody Localizacao localizacao) {

        return localizacaoService.atualizarLocalizacao(id, localizacao);
    }
}
