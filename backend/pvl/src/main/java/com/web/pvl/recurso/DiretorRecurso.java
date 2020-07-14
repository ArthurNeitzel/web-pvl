package com.web.pvl.recurso;

import com.web.pvl.servico.DiretorServico;
import com.web.pvl.servico.dto.SelectDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api/diretores")
@RequiredArgsConstructor
public class DiretorRecurso {

    private final DiretorServico diretorSevico;

    @PostMapping
    public ResponseEntity<SelectDTO> create(@RequestBody SelectDTO diretorDTO) throws URISyntaxException {
        SelectDTO novoDiretor = diretorSevico.salvar(diretorDTO);
        return ResponseEntity.created(new URI("/diretores" + novoDiretor.getValue())).body(novoDiretor);
    }


    @GetMapping
    public ResponseEntity<List<SelectDTO>> listar() {
        List<SelectDTO> diretores = diretorSevico.listar();
        return ResponseEntity.ok().body(diretores);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        diretorSevico.excluir(id);
        return ResponseEntity.ok().build();
    }

}
