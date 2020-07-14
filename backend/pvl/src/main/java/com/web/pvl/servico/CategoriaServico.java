package com.web.pvl.servico;

import com.web.pvl.dominio.Categoria;
import com.web.pvl.repositorio.CategoriaRepositorio;
import com.web.pvl.servico.dto.SelectDTO;
import com.web.pvl.servico.exception.BadRequestException;
import com.web.pvl.servico.mapper.CategoriaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoriaServico {

    CategoriaMapper categoriaMapper;
    CategoriaRepositorio categoriaRepositorio;

    public SelectDTO salvar(SelectDTO categoriaDTO) {
        Categoria categoria = categoriaRepositorio.save(categoriaMapper.toEntity(categoriaDTO));
        return categoriaMapper.toDto(categoria);
    }

    public List<SelectDTO> listar() {
        return categoriaMapper.toDto(categoriaRepositorio.findAll());
    }

    public void excluir(Long id) {
        categoriaRepositorio.deleteById(id);
    }

    public SelectDTO buscarPorID(Long id) {
        Categoria categoria = categoriaRepositorio.findById(id).orElseThrow(() -> new BadRequestException("Categoria não encontrado"));
        return categoriaMapper.toDto(categoria);
    }

}
