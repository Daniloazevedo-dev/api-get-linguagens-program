package br.com.fiap.linguagens.service.impl;

import br.com.fiap.linguagens.domain.Linguagem;
import br.com.fiap.linguagens.domain.dto.LinguagemDTO;
import br.com.fiap.linguagens.repository.LinguagemRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class LinguagemServiceImplTest {

    @InjectMocks
    private LinguagemServiceImpl linguagemService;

    @Mock
    private  LinguagemRepository linguagemRepository;

    @Mock
    private  ModelMapper mapper;

    @Test
    @DisplayName("Deve retornar uma lista de linguagens")
    void getLinguagensTest() {
        when(linguagemRepository.findAll()).thenReturn(getLinguagens());

        var linguagens = linguagemService.findAll();

        assertEquals(5, linguagens.size());
        assertEquals("JAVA", linguagens.get(0).getNome());
        assertEquals(String.class, linguagens.get(0).getNome().getClass());

    }

    @Test
    @DisplayName("Deve salvar uma lista de linguagens")
    void saveAllLinguagensTest() {
        when(linguagemRepository.saveAll(anyList())).thenReturn(getLinguagens());

        linguagemService.saveAll(getLinguagensDTO());

        verify(linguagemRepository, times(1)).saveAll(anyList());
    }

    private List<LinguagemDTO> getLinguagensDTO() {
        return List.of(
                LinguagemDTO.builder().nome("JAVA").build(),
                LinguagemDTO.builder().id("2").nome("PHP").build(),
                LinguagemDTO.builder().id("3").nome(".NET").build(),
                LinguagemDTO.builder().id("4").nome("NODE").build(),
                LinguagemDTO.builder().id("5").nome("COBOL").build());
    }

    private List<Linguagem> getLinguagens() {
        return List.of(
                Linguagem.builder().nome("JAVA").build(),
                Linguagem.builder().id("2").nome("PHP").build(),
                Linguagem.builder().id("3").nome(".NET").build(),
                Linguagem.builder().id("4").nome("NODE").build(),
                Linguagem.builder().id("5").nome("COBOL").build());
    }
}
