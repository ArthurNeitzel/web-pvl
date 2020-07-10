package com.web.pvl.servico.mapper;

import com.web.pvl.dominio.Ator;
import com.web.pvl.servico.dto.SelectDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AtorMapper extends EntityMapper<SelectDTO, Ator>{
    @Override
    @Mapping(source = "nome", target = "label")
    @Mapping(source = "id", target = "value")
    SelectDTO toDto(Ator entity);

    @Override
    @Mapping(source = "label", target = "nome")
    @Mapping(source = "value", target = "id")
    Ator toEntity(SelectDTO entity);
}
