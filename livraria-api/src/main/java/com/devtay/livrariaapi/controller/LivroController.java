package com.devtay.livrariaapi.controller;

import com.devtay.livrariaapi.dto.LivroDTO;
import com.devtay.livrariaapi.service.LivroService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/livros")
public class LivroController {

    @Autowired
    private ModelMapper mapper;
    @Autowired
    private LivroService livroService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LivroDTO salvar(@RequestBody LivroDTO livroDTO) {
        return mapper.map(livroService.salvar(livroDTO), LivroDTO.class);
    }
}
