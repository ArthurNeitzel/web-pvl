package com.web.pvl.dominio.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoItemEnum {
    DVD(1),
    FITA(0),
    BLURAY(0);

    private final Integer codigo;
}
