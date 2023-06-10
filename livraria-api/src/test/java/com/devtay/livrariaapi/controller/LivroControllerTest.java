package com.devtay.livrariaapi.controller;

import com.devtay.livrariaapi.domain.Livro;
import com.devtay.livrariaapi.dto.LivroDTO;
import com.devtay.livrariaapi.service.LivroService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("teste")
@WebMvcTest
@AutoConfigureMockMvc
public class LivroControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LivroService livroService;

    static String LIVRO_API = "/api/livros";

    @Test
    @DisplayName("Deve criar um livro com sucesso")
    public void deveCriarLivroComSucesso() throws Exception {

        LivroDTO livroDTO = LivroDTO.builder()
                .autor("Artur")
                .titulo("As aventuras de Tay")
                .isbn("12345678")
                .build();

        Livro salvarLivro = Livro.builder()
                .id(1L)
                .autor("Artur")
                .titulo("As aventuras de Tay")
                .isbn("12345678")
                .build();

        given(livroService.salvar(any(LivroDTO.class))).willReturn(salvarLivro);

        String json = new ObjectMapper().writeValueAsString(livroDTO);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post(LIVRO_API)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(json);

        mockMvc
                .perform(request)
                .andExpect(status().isCreated())
                .andExpect(jsonPath("id").isNotEmpty())
                .andExpect(jsonPath("titulo").value(livroDTO.getTitulo()))
                .andExpect(jsonPath("autor").value(livroDTO.getAutor()))
                .andExpect(jsonPath("isbn").value(livroDTO.getIsbn()));

    }

    @Test
    @DisplayName("Deve lançar erro de validação quando não houver dados suficiente para criação do livro")
    public void deveLancarErroValidacaoQuandoNaoHouverDadosSuficienteParaCriacaoLivro() {

    }
}
