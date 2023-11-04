package br.com.fiap.linguagens.service.impl;

import br.com.fiap.linguagens.domain.Linguagem;
import br.com.fiap.linguagens.domain.dto.LinguagemDTO;
import br.com.fiap.linguagens.repository.LinguagemRepository;
import br.com.fiap.linguagens.service.LinguagemService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class LinguagemServiceImpl implements LinguagemService {

    private final LinguagemRepository linguagemRepository;
    private final ModelMapper mapper;

    private static final String CACHE_NAME = "linguagens";

    @Override
    @CachePut(CACHE_NAME)
    public List<Linguagem> findAll() {
        return linguagemRepository.findAll();
    }

    @Override
    public void saveAll(List<LinguagemDTO> linguagens) {
        linguagemRepository.saveAll(linguagens
                .stream()
                .map(l -> mapper.map(l, Linguagem.class))
                .toList());
    }
}
