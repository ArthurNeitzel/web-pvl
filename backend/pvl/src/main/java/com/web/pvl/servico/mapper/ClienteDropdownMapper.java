package com.web.pvl.servico.mapper;

import com.web.pvl.dominio.Ator;
import com.web.pvl.dominio.Cliente;
import com.web.pvl.servico.dto.SelectDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClienteDropdownMapper extends EntityMapper<SelectDTO, Cliente>{
    @Override
    @Mapping(source = "nome", target = "label")
    @Mapping(source = "id", target = "value")
    SelectDTO toDto(Cliente entity);

    @Override
    @Mapping(source = "label", target = "nome")
    @Mapping(source = "value", target = "id")
    Cliente toEntity(SelectDTO entity);
}
