package com.web.pvl.dominio.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SexoEnum {
    MASCULINO(1),
    FEMININO(0);

    private final Integer codigo;
}
