package com.web.pvl.recurso;

import com.web.pvl.servico.ClasseServico;
import com.web.pvl.servico.dto.ClasseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api/classes")
@RequiredArgsConstructor
public class ClasseRecurso {

    private final ClasseServico classeSevico;

    @PostMapping
    public ResponseEntity<ClasseDTO> create(@RequestBody ClasseDTO classeDTO) throws URISyntaxException {
        ClasseDTO novoClasse = classeSevico.salvar(classeDTO);
        return ResponseEntity.created(new URI("/classes" + novoClasse.getId())).body(novoClasse);
    }


    @GetMapping
    public ResponseEntity<List<ClasseDTO>> listar() {
        List<ClasseDTO> classes = classeSevico.listar();
        return ResponseEntity.ok().body(classes);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        classeSevico.excluir(id);
        return ResponseEntity.ok().build();
    }

}
