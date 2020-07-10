package com.web.pvl.servico.mapper;

import com.web.pvl.dominio.Item;
import com.web.pvl.servico.dto.ItemDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ItemMapper extends EntityMapper<ItemDTO, Item> {

    @Override
    @Mapping(target = "titulo.id", source = "idTitulo")
    Item toEntity(ItemDTO dto);

    @Override
    @Mapping(target = "idTitulo", source = "titulo.id")
    ItemDTO toDto(Item entity);

}
