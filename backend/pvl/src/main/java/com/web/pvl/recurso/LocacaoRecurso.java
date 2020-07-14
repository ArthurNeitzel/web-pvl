package com.web.pvl.recurso;

import com.web.pvl.servico.LocacaoServico;
import com.web.pvl.servico.dto.LocacaoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api/locacaoes")
@RequiredArgsConstructor
public class LocacaoRecurso {

    private final LocacaoServico locacaoSevico;

    @PostMapping
    public ResponseEntity<LocacaoDTO> create(@RequestBody LocacaoDTO locacaoDTO) throws URISyntaxException {
        LocacaoDTO novoLocacao = locacaoSevico.salvar(locacaoDTO);
        return ResponseEntity.created(new URI("/locacaoes" + novoLocacao.getId())).body(novoLocacao);
    }


    @GetMapping
    public ResponseEntity<List<LocacaoDTO>> listar() {
        List<LocacaoDTO> locacaoes = locacaoSevico.listar();
        return ResponseEntity.ok().body(locacaoes);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        locacaoSevico.excluir(id);
        return ResponseEntity.ok().build();
    }

}
