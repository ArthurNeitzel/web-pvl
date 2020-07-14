package com.web.pvl.servico;


import com.web.pvl.dominio.Locacao;
import com.web.pvl.repositorio.LocacaoRepositorio;
import com.web.pvl.servico.dto.LocacaoDTO;
import com.web.pvl.servico.exception.BadRequestException;
import com.web.pvl.servico.mapper.LocacaoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class LocacaoServico {

    LocacaoMapper locacaoMapper;
    LocacaoRepositorio locacaoRepositorio;

    public LocacaoDTO salvar(LocacaoDTO locacaoDTO) {
        Locacao locacao = locacaoRepositorio.save(locacaoMapper.toEntity(locacaoDTO));
        return locacaoMapper.toDto(locacao);
    }

    public List<LocacaoDTO> listar() {
        return locacaoMapper.toDto(locacaoRepositorio.findAll());
    }

    public void excluir(Long id) {
        locacaoRepositorio.deleteById(id);
    }

    public LocacaoDTO buscarPorID(Long id) {
        Locacao locacao = locacaoRepositorio.findById(id).orElseThrow(() -> new BadRequestException("Categoria não encontrado"));
        return locacaoMapper.toDto(locacao);
    }

}
