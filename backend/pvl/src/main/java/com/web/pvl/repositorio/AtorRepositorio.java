package com.web.pvl.repositorio;

import com.web.pvl.dominio.Ator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AtorRepositorio extends JpaRepository<Ator, Long>, JpaSpecificationExecutor<Ator> {
}
