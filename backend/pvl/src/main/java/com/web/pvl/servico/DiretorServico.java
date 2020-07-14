package com.web.pvl.servico;

import com.web.pvl.dominio.Diretor;
import com.web.pvl.repositorio.DiretorRepositorio;
import com.web.pvl.servico.dto.SelectDTO;
import com.web.pvl.servico.exception.BadRequestException;
import com.web.pvl.servico.mapper.DiretorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class DiretorServico {

    DiretorMapper diretorMapper;
    DiretorRepositorio diretorRepositorio;

    public SelectDTO salvar(SelectDTO diretorDTO) {
        Diretor diretor = diretorRepositorio.save(diretorMapper.toEntity(diretorDTO));
        return diretorMapper.toDto(diretor);
    }

    public List<SelectDTO> listar() {
        return diretorMapper.toDto(diretorRepositorio.findAll());
    }

    public void excluir(Long id) {
        diretorRepositorio.deleteById(id);
    }

    public SelectDTO buscarPorID(Long id) {
        Diretor diretor = diretorRepositorio.findById(id).orElseThrow(() -> new BadRequestException("Categoria não encontrado"));
        return diretorMapper.toDto(diretor);
    }

}
