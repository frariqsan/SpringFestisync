package es.severo.festisync.repository;

import es.severo.festisync.entities.Evento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface EventoRepository extends JpaRepository<Evento, Integer> {
    Page<Evento> findByFechaBetween(LocalDate fechaInicio, LocalDate fechaFin, Pageable pageable);
}
