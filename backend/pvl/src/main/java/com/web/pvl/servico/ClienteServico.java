package com.web.pvl.servico;


import com.web.pvl.dominio.Dependente;
import com.web.pvl.dominio.Socio;
import com.web.pvl.repositorio.ClienteRepositorio;
import com.web.pvl.repositorio.DependenteRepositorio;
import com.web.pvl.repositorio.SocioRepositorio;
import com.web.pvl.servico.dto.DependenteDTO;
import com.web.pvl.servico.dto.SocioDTO;
import com.web.pvl.servico.exception.BadRequestException;
import com.web.pvl.servico.mapper.DependenteMapper;
import com.web.pvl.servico.mapper.SocioMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ClienteServico {

    SocioMapper socioMapper;
    DependenteMapper dependenteMapper;
    ClienteRepositorio clienteRepositorio;
    DependenteRepositorio dependenteRepositorio;
    SocioRepositorio socioRepositorio;

    public SocioDTO salvarSocio(SocioDTO clienteDTO) {
        Socio cliente = socioRepositorio.save(socioMapper.toEntity(clienteDTO));
        return socioMapper.toDto(cliente);
    }

    public DependenteDTO salvarDependente(DependenteDTO clienteDTO) {
        Dependente cliente = dependenteRepositorio.save(dependenteMapper.toEntity(clienteDTO));
        return dependenteMapper.toDto(cliente);
    }

    public List<SocioDTO> listarSocios() {
        return socioMapper.toDto(socioRepositorio.findAll());
    }

    public List<DependenteDTO> listarDependentes() {
        return dependenteMapper.toDto(dependenteRepositorio.findAll());
    }

    public void excluir(Long id) {
        clienteRepositorio.deleteById(id);
    }

    public SocioDTO buscarSocioPorID(Long id) {
        Socio cliente = socioRepositorio.findById(id).orElseThrow(() -> new BadRequestException("Cliente não encontrado"));
        return socioMapper.toDto(cliente);
    }

    public DependenteDTO buscarDependentePorID(Long id) {
        Dependente cliente = dependenteRepositorio.findById(id).orElseThrow(() -> new BadRequestException("Cliente não encontrado"));
        return dependenteMapper.toDto(cliente);
    }
}
