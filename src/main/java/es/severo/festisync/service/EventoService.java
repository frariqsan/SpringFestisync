package es.severo.festisync.service;

import es.severo.festisync.entities.Evento;
import es.severo.festisync.repository.EventoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;


@Service
public class EventoService {
    private EventoRepository eventoRepository;
    public EventoService(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    public Page<Evento> findAll(Pageable pageable) {
        return eventoRepository.findAll(pageable);
    }

    public Page<Evento> findByRangoFecha(LocalDate fechaInicio, LocalDate fechaFin, Pageable pageable) {
        if (fechaInicio == null || fechaFin == null) {
            return eventoRepository.findAll(pageable);
        }
        return eventoRepository.findByFechaBetween(fechaInicio, fechaFin, pageable);
    }
}
