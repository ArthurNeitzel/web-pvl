package com.web.pvl.repositorio;

import com.web.pvl.dominio.Cliente;
import com.web.pvl.dominio.Socio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SocioRepositorio extends JpaRepository<Socio, Long>, JpaSpecificationExecutor<Socio> {
}
