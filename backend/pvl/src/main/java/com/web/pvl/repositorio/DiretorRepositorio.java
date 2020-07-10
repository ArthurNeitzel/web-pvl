package com.web.pvl.repositorio;

import com.web.pvl.dominio.Diretor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DiretorRepositorio extends JpaRepository<Diretor, Long>, JpaSpecificationExecutor<Diretor> {
}
