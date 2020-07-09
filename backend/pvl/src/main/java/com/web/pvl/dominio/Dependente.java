package com.web.pvl.dominio;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Entity
public class Dependente extends Cliente{

    @ManyToOne
    @JoinColumn(name = "ID_RESPONSAVEL")
    private Socio responsavel;

}
