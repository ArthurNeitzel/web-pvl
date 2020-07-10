package com.web.pvl.servico.mapper;

import com.web.pvl.dominio.Locacao;
import com.web.pvl.servico.dto.LocacaoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LocacaoMapper extends EntityMapper<LocacaoDTO, Locacao> {

    @Override
    @Mapping(target = "item.id", source = "idItem")
    @Mapping(target = "cliente.id", source = "idCliente")
    Locacao toEntity(LocacaoDTO dto);

    @Override
    @Mapping(target = "idItem", source = "item.id")
    @Mapping(target = "idCliente", source = "cliente.id")
    LocacaoDTO toDto(Locacao entity);

}
