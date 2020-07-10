package com.web.pvl.servico.mapper;

import com.web.pvl.dominio.Socio;
import com.web.pvl.servico.dto.SocioDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SocioMapper extends EntityMapper<SocioDTO, Socio>{
}
