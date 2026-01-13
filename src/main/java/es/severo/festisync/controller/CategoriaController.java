package es.severo.festisync.controller;

import es.severo.festisync.dto.ArtistaDTO;
import es.severo.festisync.dto.CategoriaDTO;
import es.severo.festisync.service.CategoriaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {
    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }
    @GetMapping
    public ResponseEntity<Page<CategoriaDTO>> findAll(Pageable pageable) {
        Page<CategoriaDTO> p = categoriaService.findAll(pageable)
                .map(x -> new CategoriaDTO(
                        x.getId(),
                        x.getNombre()
                ));
        return ResponseEntity.ok(p);
    }

    @GetMapping("/nombre/{name}")
    public ResponseEntity<Page<CategoriaDTO>> findByName(String name, Pageable pageable) {
        Page<CategoriaDTO> p = categoriaService.findByName(name, pageable)
                .map(x -> new CategoriaDTO(
                        x.getId(),
                        x.getNombre()
                ));

        return ResponseEntity.ok(p);
    }
}
