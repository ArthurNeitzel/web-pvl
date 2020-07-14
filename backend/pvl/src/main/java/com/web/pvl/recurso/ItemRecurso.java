package com.web.pvl.recurso;

import com.web.pvl.servico.ItemServico;
import com.web.pvl.servico.dto.ItemDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api/itens")
@RequiredArgsConstructor
public class ItemRecurso {

    private final ItemServico itemSevico;

    @PostMapping
    public ResponseEntity<ItemDTO> create(@RequestBody ItemDTO itemDTO) throws URISyntaxException {
        ItemDTO novoItem = itemSevico.salvar(itemDTO);
        return ResponseEntity.created(new URI("/itens" + novoItem.getId())).body(novoItem);
    }


    @GetMapping
    public ResponseEntity<List<ItemDTO>> listar() {
        List<ItemDTO> itemes = itemSevico.listar();
        return ResponseEntity.ok().body(itemes);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        itemSevico.excluir(id);
        return ResponseEntity.ok().build();
    }

}
