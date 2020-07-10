package com.web.pvl.servico.mapper;

import com.web.pvl.dominio.Categoria;
import com.web.pvl.servico.dto.SelectDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoriaMapper extends EntityMapper<SelectDTO, Categoria>{
    @Override
    @Mapping(source = "descricao", target = "label")
    @Mapping(source = "id", target = "value")
    SelectDTO toDto(Categoria entity);

    @Override
    @Mapping(source = "label", target = "descricao")
    @Mapping(source = "value", target = "id")
    Categoria toEntity(SelectDTO entity);
}
