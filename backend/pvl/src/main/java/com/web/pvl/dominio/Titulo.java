package com.web.pvl.dominio;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "TITULO")
public class Titulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Column(name = "ANO", nullable = false)
    private LocalDate ano;

    @Column(name = "SINOPSE", nullable = false)
    private String sinopse;

    @ManyToOne
    @JoinColumn(name = "ID_CATEGORIA", nullable = false)
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "ID_DIRETOR", nullable = false)
    private Diretor diretor;

    @ManyToOne
    @JoinColumn(name = "ID_CLASSE", nullable = false)
    private Classe classe;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "TITULO_ATOR",
            joinColumns = @JoinColumn(name = "ID_TITULO", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "ID_ATOR", referencedColumnName = "ID"))
    private List<Ator> atores;
}
