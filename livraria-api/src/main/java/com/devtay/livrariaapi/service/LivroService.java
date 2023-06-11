package com.devtay.livrariaapi.service;

import com.devtay.livrariaapi.domain.Livro;
import com.devtay.livrariaapi.dto.LivroDTO;
import com.devtay.livrariaapi.repository.LivroRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivroService {

    @Autowired
    private ModelMapper mapper = new ModelMapper();

    @Autowired
    private LivroRepository livroRepository;

    public Livro salvar(LivroDTO livroDTO) {
        return mapper.map(livroDTO, Livro.class);
    }
}
