package com.web.pvl.repositorio;

import com.web.pvl.dominio.Dependente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DependenteRepositorio extends JpaRepository<Dependente, Long>, JpaSpecificationExecutor<Dependente> {
}
