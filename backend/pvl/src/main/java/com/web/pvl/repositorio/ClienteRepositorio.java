package com.web.pvl.repositorio;

import com.web.pvl.dominio.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ClienteRepositorio extends JpaRepository<Cliente, Long>, JpaSpecificationExecutor<Cliente> {
}
