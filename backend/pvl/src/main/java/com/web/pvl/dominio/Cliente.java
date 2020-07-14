package com.web.pvl.dominio;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "CLIENTE")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOME", nullable = false, length = 80)
    private String nome;

    @Column(name = "DATA_NASCIMENTO", nullable = false)
    private LocalDate dataNascimento;

    @Column(name = "ATIVO", nullable = false)
    private Boolean ativo;

    @Column(name = "SEXO", nullable = false)
    private Integer sexo;

    @Column(name = "TIPO_CLIENTE", nullable = false)
    private Integer tipoCLiente;
}
