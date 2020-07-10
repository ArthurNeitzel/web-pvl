package com.web.pvl.servico.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SocioDTO extends ClienteDTO{
    private String cpf;
    private String endereco;
    private String telefone;
}
