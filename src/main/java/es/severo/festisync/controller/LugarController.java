package es.severo.festisync.controller;

import es.severo.festisync.dto.ArtistaDTO;
import es.severo.festisync.dto.LugarDTO;
import es.severo.festisync.entities.Lugar;
import es.severo.festisync.service.LugarService;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lugar")
public class LugarController {
    private final LugarService lugarService;

    public LugarController(LugarService lugarService) {
        this.lugarService = lugarService;
    }
    @GetMapping
    public Page<Lugar> findAll(@ParameterObject Pageable pageable) {
        return lugarService.findAll(pageable);
    }
    @GetMapping("/aforo-desc")
    public ResponseEntity<Page<LugarDTO>> findOrderedDesc(@ParameterObject Pageable pageable) {
        Page<LugarDTO> p = lugarService.findAllByOrderByAforoDesc(pageable)
                .map(x -> new LugarDTO(
                        x.getId(),
                        x.getNombre(),
                        x.getCiudad(),
                        x.getAforo()
                ));

        return ResponseEntity.ok(p);

    }

    @GetMapping("/nombre/{name}")
    public ResponseEntity<Page<LugarDTO>> findByName(@PathVariable(name = "name") String name, @ParameterObject Pageable pageable) {
        Page<LugarDTO> p = lugarService.findByName(name, pageable)
                .map(x -> new LugarDTO(
                        x.getId(),
                        x.getNombre(),
                        x.getCiudad(),
                        x.getAforo()
                ));

        return ResponseEntity.ok(p);
    }


}
