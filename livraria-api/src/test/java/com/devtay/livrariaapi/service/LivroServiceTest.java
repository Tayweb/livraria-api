package com.devtay.livrariaapi.service;

import com.devtay.livrariaapi.domain.Livro;
import com.devtay.livrariaapi.dto.LivroDTO;
import com.devtay.livrariaapi.repository.LivroRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("teste")
public class LivroServiceTest {

    private LivroService livroService;

    @MockBean
    private LivroRepository livroRepository;

    @BeforeEach
    public void setUp(){
        livroService = new LivroService();
    }

    @Test
    @DisplayName("Deve salvar um livro")
    public void deveSalvarLivro() {

        LivroDTO livroDTO = LivroDTO.builder()
                .autor("Raquel")
                .isbn("12345")
                .titulo("Testando um teste")
                .build();

        Livro newLivro = livroService.salvar(livroDTO);

        assertThat(newLivro.getId()).isNotNull();
        assertThat(newLivro.getIsbn()).isEqualTo("12345");
        assertThat(newLivro.getAutor()).isEqualTo("Raquel");
        assertThat(newLivro.getTitulo()).isEqualTo("Testando um teste");

    }
}
