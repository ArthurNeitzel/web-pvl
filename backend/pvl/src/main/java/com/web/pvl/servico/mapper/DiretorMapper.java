package com.web.pvl.servico.mapper;

import com.web.pvl.dominio.Diretor;
import com.web.pvl.servico.dto.SelectDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DiretorMapper extends EntityMapper<SelectDTO, Diretor>{
    @Override
    @Mapping(source = "nome", target = "label")
    @Mapping(source = "id", target = "value")
    SelectDTO toDto(Diretor entity);

    @Override
    @Mapping(source = "label", target = "nome")
    @Mapping(source = "value", target = "id")
    Diretor toEntity(SelectDTO entity);
}
