package com.web.pvl.servico;


import com.web.pvl.dominio.Titulo;
import com.web.pvl.repositorio.TituloRepositorio;
import com.web.pvl.servico.dto.TituloDTO;
import com.web.pvl.servico.exception.BadRequestException;
import com.web.pvl.servico.mapper.TituloMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TituloServico {

    TituloMapper tituloMapper;
    TituloRepositorio tituloRepositorio;

    public TituloDTO salvar(TituloDTO tituloDTO) {
        Titulo titulo = tituloRepositorio.save(tituloMapper.toEntity(tituloDTO));
        return tituloMapper.toDto(titulo);
    }

    public List<TituloDTO> listar() {
        return tituloMapper.toDto(tituloRepositorio.findAll());
    }

    public void excluir(Long id) {
        tituloRepositorio.deleteById(id);
    }

    public TituloDTO buscarPorID(Long id) {
        Titulo titulo = tituloRepositorio.findById(id).orElseThrow(() -> new BadRequestException("Categoria não encontrado"));
        return tituloMapper.toDto(titulo);
    }

}
