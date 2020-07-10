package com.web.pvl.servico.mapper;

import com.web.pvl.dominio.Dependente;
import com.web.pvl.servico.dto.DependenteDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DependenteMapper extends EntityMapper<DependenteDTO, Dependente> {

    @Override
    @Mapping(target = "responsavel.id", source = "idResponsavel")
    Dependente toEntity(DependenteDTO dto);

    @Override
    @Mapping(target = "idResponsavel", source = "responsavel.id")
    DependenteDTO toDto(Dependente entity);

}
