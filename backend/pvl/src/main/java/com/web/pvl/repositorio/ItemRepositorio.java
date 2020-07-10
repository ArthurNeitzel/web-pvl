package com.web.pvl.repositorio;

import com.web.pvl.dominio.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ItemRepositorio extends JpaRepository<Item, Long>, JpaSpecificationExecutor<Item> {
}
