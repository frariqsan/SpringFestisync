package es.severo.festisync.dto;

import java.time.LocalDate;

public record EventoDTO(Integer id, String name, LocalDate fecha) {
}
