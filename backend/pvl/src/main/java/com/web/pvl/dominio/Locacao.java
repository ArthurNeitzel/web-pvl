package com.web.pvl.dominio;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "LOCACAO")
public class Locacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "DATA_LOCACAO", nullable = false)
    private LocalDate dataLocacao;

    @Column(name = "DATA_DEVOLUCAO_PREVISTA", nullable = false)
    private LocalDate dataDevolucaoPrevista;

    @Column(name = "DATA_DEVOLUCAO", nullable = true)
    private LocalDate dataDevolucao;

    @Column(name = "VALOR", nullable = false)
    private Double valor;

    @Column(name = "MULTA", nullable = false)
    private Double multa;

    @ManyToOne
    @JoinColumn(name = "ID_ITEM", nullable = false)
    private Item item;

    @ManyToOne
    @JoinColumn(name = "ID_CLIENTE", nullable = false)
    private Cliente cliente;
}
