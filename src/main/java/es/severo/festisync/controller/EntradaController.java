package es.severo.festisync.controller;

import es.severo.festisync.dto.EntradaDTO;
import es.severo.festisync.entities.Entrada;
import es.severo.festisync.entities.EntradaTipo;
import es.severo.festisync.service.EntradaService;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/entrada")
public class EntradaController {
    private final EntradaService entradaService;

    public EntradaController(EntradaService entradaService) {
        this.entradaService = entradaService;
    }
    @GetMapping
    public ResponseEntity<Page<EntradaDTO>> findAll(@ParameterObject Pageable pageable) {
        Page<EntradaDTO> p = entradaService.findAll(pageable)
                .map(x -> new EntradaDTO(
                        x.getId(),
                        x.getTipo().name(),
                        x.getPrecio()
                ));
        return ResponseEntity.ok(p);
    }
    @GetMapping("/buscar-tipo")
    public ResponseEntity<Page<EntradaDTO>> findByType(EntradaTipo tipo, @ParameterObject Pageable pageable) {
        Page<Entrada> entradaPage = entradaService.findByType(tipo, pageable);
        Page<EntradaDTO> dtoPage = entradaPage.map(x -> new EntradaDTO(
                x.getId(),
                x.getTipo().name(),
                x.getPrecio()
        ));
        return ResponseEntity.ok(dtoPage);
    }

    @GetMapping("/filtro-precio")
    public ResponseEntity<Page<EntradaDTO>> getByPrecioMax(BigDecimal precioMax, @ParameterObject Pageable pageable)
     {
         Page<Entrada> entradas = entradaService.findByPrecioLessThanEqual(precioMax, pageable);
         Page<EntradaDTO> dtoPage = entradas.map(x -> new EntradaDTO(
                 x.getId(),
                 x.getTipo().name(),
                 x.getPrecio()
         ));
         return ResponseEntity.ok(dtoPage);
    }
}
