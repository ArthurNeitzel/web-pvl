package com.web.pvl.servico.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClasseDTO {
    private Long id;
    private String nome;
    private double valor;
    private int prazo;
}
