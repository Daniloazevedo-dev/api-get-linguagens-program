package br.com.fiap.linguagens.controller;

import br.com.fiap.linguagens.domain.dto.LinguagemDTO;
import br.com.fiap.linguagens.service.LinguagemService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/linguagens")
public class LinguagemController {

    private final LinguagemService linguagemService;
    private final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<LinguagemDTO>> findAll() {
        return ResponseEntity.status(OK)
                .body(linguagemService.findAll()
                        .stream()
                        .map(l -> mapper.map(l, LinguagemDTO.class))
                        .toList());
    }
}
