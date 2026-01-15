package es.severo.festisync.controller;

import es.severo.festisync.dto.ArtistaDTO;
import es.severo.festisync.dto.EventoDTO;
import es.severo.festisync.entities.Artista;
import es.severo.festisync.repository.ArtistaRepository;
import es.severo.festisync.service.EventoService;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/evento")
public class EventoController {
    private final EventoService eventoService;
    private final ArtistaRepository artistaRepository;

    public EventoController(EventoService eventoService, ArtistaRepository artistaRepository) {
        this.eventoService = eventoService;
        this.artistaRepository = artistaRepository;
    }

    @GetMapping
    public ResponseEntity<Page<EventoDTO>> findAll(@ParameterObject Pageable pageable) {
        Page<EventoDTO> p = eventoService.findAll(pageable)
                .map(x -> new EventoDTO(
                        x.getId(),
                        x.getNombre(),
                        x.getFecha()
                ));
        return ResponseEntity.ok(p);
    }

    //RelacionExpuesta
    @GetMapping("/{id}/artistas")
    public ResponseEntity<Page<ArtistaDTO>> getArtistasByEvento(@PathVariable Integer id, @ParameterObject Pageable pageable) {
        Page<Artista> artistas = artistaRepository.findByEventoId(id, pageable);
        return ResponseEntity.ok(artistas.map(x -> new ArtistaDTO(
                x.getId(),
                x.getNombre(),
                x.getGeneroMusical(),
                x.getPais()
        )));
    }

    //FIND_FECHAS
    @GetMapping("/fechas")
    public ResponseEntity<Page<EventoDTO>> getByRangoFecha(LocalDate fechaInicio, LocalDate fechaFin, @ParameterObject Pageable pageable) {
        Page<EventoDTO> p = eventoService.findByRangoFecha(fechaInicio,fechaFin,pageable)
                .map(x -> new EventoDTO(
                        x.getId(),
                        x.getNombre(),
                        x.getFecha()
                ));
        return ResponseEntity.ok(p);
    }
}
