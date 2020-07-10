package com.web.pvl.servico.mapper;

import com.web.pvl.dominio.Classe;
import com.web.pvl.servico.dto.ClasseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClasseMapper extends EntityMapper<ClasseDTO, Classe> {
}
