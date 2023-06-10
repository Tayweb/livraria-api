package com.devtay.livrariaapi.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Livro {

    private Long id;
    private String titulo;
    private String autor;
    private String isbn;
}
