package com.luiz.wms.service;

import com.luiz.wms.entity.Localizacao;
import com.luiz.wms.repository.LocalizacaoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class LocalizacaoService {

    private final LocalizacaoRepository localizacaoRepository;

    public LocalizacaoService(LocalizacaoRepository localizacaoRepository){
        this.localizacaoRepository = localizacaoRepository;
    }

    public List<Localizacao> listarTodos(){
        return localizacaoRepository.findAll();
    }

    public Localizacao cadastrarLocalizacao(Localizacao localizacao) {
        return localizacaoRepository.save(localizacao);
    }

    public Localizacao buscarPorId(Long id) {
        return localizacaoRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Localização não encontrada"
                        )
                );
    }

    public Localizacao atualizarLocalizacao(Long id,Localizacao localizacao){
        Localizacao localizacaoExistente = buscarPorId(id);

        localizacaoExistente.setCodigo(localizacao.getCodigo());
        localizacaoExistente.setDescricao(localizacao.getDescricao());
        localizacaoExistente.setAtivo(localizacao.getAtivo());

        return localizacaoRepository.save(localizacaoExistente);
    }
}
