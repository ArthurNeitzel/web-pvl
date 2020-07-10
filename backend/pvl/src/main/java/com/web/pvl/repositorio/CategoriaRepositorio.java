package com.web.pvl.repositorio;

import com.web.pvl.dominio.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CategoriaRepositorio extends JpaRepository<Categoria, Long>, JpaSpecificationExecutor<Categoria> {
}
