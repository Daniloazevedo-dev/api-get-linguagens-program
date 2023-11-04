package br.com.fiap.linguagens.config;

import br.com.fiap.linguagens.domain.Linguagem;
import br.com.fiap.linguagens.domain.dto.LinguagemDTO;
import br.com.fiap.linguagens.service.LinguagemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Component
public class DataInitializer implements CommandLineRunner {

    private final LinguagemService linguagemService;
    private final MongoTemplate mongoTemplate;

    @Override
    public void run(String... args) {
        mongoTemplate.dropCollection(Linguagem.class);
        linguagemService.saveAll(createLinguagens());
    }

    private List<LinguagemDTO> createLinguagens() {
        return List.of(
                LinguagemDTO.builder().nome("JAVA").build(),
                LinguagemDTO.builder().nome("PHP").build(),
                LinguagemDTO.builder().nome(".NET").build(),
                LinguagemDTO.builder().nome("NODE").build(),
                LinguagemDTO.builder().nome("COBOL").build());
    }
}
