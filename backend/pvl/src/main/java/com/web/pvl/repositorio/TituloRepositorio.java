package com.web.pvl.repositorio;

import com.web.pvl.dominio.Titulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TituloRepositorio extends JpaRepository<Titulo, Long>, JpaSpecificationExecutor<Titulo> {
}
