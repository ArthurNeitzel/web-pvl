package com.web.pvl.servico;

import com.web.pvl.dominio.Categoria;
import com.web.pvl.dominio.Classe;
import com.web.pvl.repositorio.ClasseRepositorio;
import com.web.pvl.servico.dto.ClasseDTO;
import com.web.pvl.servico.dto.SelectDTO;
import com.web.pvl.servico.exception.BadRequestException;
import com.web.pvl.servico.mapper.ClasseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ClasseServico {

    ClasseRepositorio classeRepositorio;
    ClasseMapper classeMapper;

    public ClasseDTO salvar(ClasseDTO classeDTO) {
        Classe categoria = classeRepositorio.save(classeMapper.toEntity(classeDTO));
        return classeMapper.toDto(categoria);
    }

    public List<ClasseDTO> listar() {
        return classeMapper.toDto(classeRepositorio.findAll());
    }

    public void excluir(Long id) {
        classeRepositorio.deleteById(id);
    }

    public ClasseDTO buscarPorID(Long id) {
        Classe categoria = classeRepositorio.findById(id).orElseThrow(() -> new BadRequestException("Categoria não encontrado"));
        return classeMapper.toDto(categoria);
    }
}
