package com.web.pvl.repositorio;

import com.web.pvl.dominio.Locacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface LocacaoRepositorio extends JpaRepository<Locacao, Long>, JpaSpecificationExecutor<Locacao> {
}
