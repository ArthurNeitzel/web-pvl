package com.web.pvl.dominio.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoClienteEnum {
    SOCIO(1),
    DEPENDENTE(0);

    private final Integer codigo;
}
