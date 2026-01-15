package es.severo.festisync.controller;

import es.severo.festisync.dto.ArtistaDTO;
import es.severo.festisync.entities.Artista;
import es.severo.festisync.service.ArtistaService;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/artista")
public class ArtistaController {
    private final ArtistaService artistaService;

    public ArtistaController(ArtistaService artistaService) {
        this.artistaService = artistaService;
    }


    @GetMapping
    public ResponseEntity<Page<ArtistaDTO>> findAll(@ParameterObject Pageable pageable) {
        Page<ArtistaDTO> p = artistaService.findAll(pageable)
                .map(x -> new ArtistaDTO(
                        x.getId(),
                        x.getNombre(),
                        x.getGeneroMusical(),
                        x.getPais()
                ));
        return ResponseEntity.ok(p);
    }

    @GetMapping("/nombre/{name}")
    public ResponseEntity<Page<ArtistaDTO>> findByName(@PathVariable(name = "name") String name, @ParameterObject Pageable pageable) {
        Page<ArtistaDTO> p = artistaService.findByName(name, pageable)
                .map(x -> new ArtistaDTO(
                        x.getId(),
                        x.getNombre(),
                        x.getGeneroMusical(),
                        x.getPais()
                ));

        return ResponseEntity.ok(p);
    }


    //CRUD PRINCIPAL
    @PostMapping
    public ResponseEntity<ArtistaDTO> create(@RequestBody ArtistaDTO dto) {
        Artista artista = new Artista();
        artista.setNombre(dto.name());
        artista.setPais(dto.pais());
        artista.setGeneroMusical(dto.generoMusical());

        Artista saved = artistaService.save(artista);

        ArtistaDTO respuesta = new ArtistaDTO(
                saved.getId(),
                saved.getNombre(),
                saved.getPais(),
                saved.getGeneroMusical()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(respuesta);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ArtistaDTO> update(
            @PathVariable Integer id,
            @RequestBody ArtistaDTO dto
    ) {
        Optional<Artista> artistaOpt =  artistaService.findById(id);
        if (artistaOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Artista artista = artistaOpt.get();
        artista.setNombre(dto.name());
        artista.setPais(dto.pais());
        artista.setGeneroMusical(dto.generoMusical());

        Artista updated = artistaService.save(artista);

        ArtistaDTO dtoUpdated = new ArtistaDTO(
                updated.getId(),
                updated.getNombre(),
                updated.getPais(),
                updated.getGeneroMusical()
        );
        return ResponseEntity.ok(dtoUpdated);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ArtistaDTO> getById(@PathVariable Integer id) {
        return artistaService.findById(id)
                .map(a -> new ArtistaDTO(
                        a.getId(),
                        a.getNombre(),
                        a.getGeneroMusical(),
                        a.getPais()
                ))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (artistaService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        artistaService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
