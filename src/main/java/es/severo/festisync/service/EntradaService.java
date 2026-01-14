package es.severo.festisync.service;


import es.severo.festisync.entities.Entrada;
import es.severo.festisync.entities.EntradaTipo;
import es.severo.festisync.repository.EntradaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class EntradaService {
    private final EntradaRepository entradaRepository;
    public EntradaService(EntradaRepository entradaRepository) {
        this.entradaRepository = entradaRepository;
    }

    public Page<Entrada> findAll(Pageable pageable) {
        return entradaRepository.findAll(pageable);
    }
    public Page<Entrada> findByType(EntradaTipo tipo, Pageable pageable) {
        return entradaRepository.findByTipo(tipo, pageable);
    }

    public Page<Entrada> findByPrecioLessThanEqual(BigDecimal precioMax, Pageable pageable) {
        return entradaRepository.findByPrecioLessThanEqual(precioMax, pageable);
    }

    //CRUD
    public Optional<Entrada> findById(Integer id) {
        return entradaRepository.findById(id);
    }
    public Entrada save(Entrada entrada) {
        return entradaRepository.save(entrada);
    }
    public void deleteById(Integer id) {
        entradaRepository.deleteById(id);
    }
}
