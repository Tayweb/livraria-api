package com.devtay.livrariaapi.service;

import com.devtay.livrariaapi.domain.Livro;
import com.devtay.livrariaapi.dto.LivroDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivroService {

    @Autowired
    private ModelMapper mapper;

    public Livro salvar(LivroDTO livroDTO) {
        return mapper.map(livroDTO, Livro.class);
    }
}
