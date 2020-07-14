package com.web.pvl.servico;

import com.web.pvl.dominio.Ator;
import com.web.pvl.repositorio.AtorRepositorio;
import com.web.pvl.servico.dto.SelectDTO;
import com.web.pvl.servico.exception.BadRequestException;
import com.web.pvl.servico.mapper.AtorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AtorServico {

    AtorMapper atorMapper;
    AtorRepositorio atorRepositorio;

    public SelectDTO salvar(SelectDTO atorDTO) {
        Ator ator = atorRepositorio.save(atorMapper.toEntity(atorDTO));
        return atorMapper.toDto(ator);
    }

    public List<SelectDTO> listar() {
        return atorMapper.toDto(atorRepositorio.findAll());
    }

    public void excluir(Long id) {
        atorRepositorio.deleteById(id);
    }

    public SelectDTO buscarPorID(Long id) {
        Ator ator = atorRepositorio.findById(id).orElseThrow(() -> new BadRequestException("Ator não encontrado"));
        return atorMapper.toDto(ator);
    }

}
