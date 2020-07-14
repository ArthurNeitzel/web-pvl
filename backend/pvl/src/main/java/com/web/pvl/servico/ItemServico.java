package com.web.pvl.servico;


import com.web.pvl.dominio.Item;
import com.web.pvl.repositorio.ItemRepositorio;
import com.web.pvl.servico.dto.ItemDTO;
import com.web.pvl.servico.dto.SelectDTO;
import com.web.pvl.servico.exception.BadRequestException;
import com.web.pvl.servico.mapper.ItemMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ItemServico {

    ItemMapper itemMapper;
    ItemRepositorio itemRepositorio;

    public ItemDTO salvar(ItemDTO itemDTO) {
        Item item = itemRepositorio.save(itemMapper.toEntity(itemDTO));
        return itemMapper.toDto(item);
    }

    public List<ItemDTO> listar() {
        return itemMapper.toDto(itemRepositorio.findAll());
    }

    public void excluir(Long id) {
        itemRepositorio.deleteById(id);
    }

    public ItemDTO buscarPorID(Long id) {
        Item item = itemRepositorio.findById(id).orElseThrow(() -> new BadRequestException("Categoria não encontrado"));
        return itemMapper.toDto(item);
    }

}
