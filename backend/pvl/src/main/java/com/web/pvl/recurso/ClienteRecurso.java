package com.web.pvl.recurso;

import com.web.pvl.servico.AtorServico;
import com.web.pvl.servico.dto.SelectDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api/atores")
@RequiredArgsConstructor
public class ClienteRecurso {

    private final AtorServico atorSevico;

    @PostMapping
    public ResponseEntity<SelectDTO> create(@RequestBody SelectDTO atorDTO) throws URISyntaxException {
        SelectDTO novoAtor = atorSevico.salvar(atorDTO);
        return ResponseEntity.created(new URI("/atores" + novoAtor.getValue())).body(novoAtor);
    }


    @GetMapping
    public ResponseEntity<List<SelectDTO>> listar() {
        List<SelectDTO> atores = atorSevico.listar();
        return ResponseEntity.ok().body(atores);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        atorSevico.excluir(id);
        return ResponseEntity.ok().build();
    }

}
