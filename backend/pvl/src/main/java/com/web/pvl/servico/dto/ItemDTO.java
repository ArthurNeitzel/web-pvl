package com.web.pvl.servico.dto;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ItemDTO {
    private Long id;
    private Long numeroSerie;
    private LocalDate dataAquisicao;
    private Integer tipoItem;
    private Long idTitulo;
}
