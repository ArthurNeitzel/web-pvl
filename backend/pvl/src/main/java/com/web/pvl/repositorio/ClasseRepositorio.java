package com.web.pvl.repositorio;

import com.web.pvl.dominio.Classe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ClasseRepositorio extends JpaRepository<Classe, Long>, JpaSpecificationExecutor<Classe> {
}
