package br.com.fiap.linguagens.service;

import br.com.fiap.linguagens.domain.Linguagem;
import br.com.fiap.linguagens.domain.dto.LinguagemDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface LinguagemService {
    @Transactional(readOnly = true)
    List<Linguagem> findAll();

    @Transactional
    void saveAll(List<LinguagemDTO> linguagens);

}
