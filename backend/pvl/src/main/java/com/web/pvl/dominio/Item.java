package com.web.pvl.dominio;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "ITEM")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "NUMERO_SERIE", nullable = false)
    private Long numeroSerie;

    @Column(name = "DATA_AQUISICAO", nullable = false)
    private LocalDate dataAquisicao;

    @Column(name = "TIPO_ITEM", nullable = false)
    private Integer tipoItem;

    @ManyToOne
    @JoinColumn(name = "ID_TITULO", nullable = false)
    private Titulo titulo;
}
