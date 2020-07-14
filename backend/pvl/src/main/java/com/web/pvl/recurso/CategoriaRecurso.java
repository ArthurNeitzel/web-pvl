package com.web.pvl.recurso;

import com.web.pvl.servico.CategoriaServico;
import com.web.pvl.servico.dto.SelectDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api/categorias")
@RequiredArgsConstructor
public class CategoriaRecurso {

    private final CategoriaServico categoriaSevico;

    @PostMapping
    public ResponseEntity<SelectDTO> create(@RequestBody SelectDTO categoriaDTO) throws URISyntaxException {
        SelectDTO novoCategoria = categoriaSevico.salvar(categoriaDTO);
        return ResponseEntity.created(new URI("/categoriaes" + novoCategoria.getValue())).body(novoCategoria);
    }


    @GetMapping
    public ResponseEntity<List<SelectDTO>> listar() {
        List<SelectDTO> categoriaes = categoriaSevico.listar();
        return ResponseEntity.ok().body(categoriaes);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        categoriaSevico.excluir(id);
        return ResponseEntity.ok().build();
    }

}
