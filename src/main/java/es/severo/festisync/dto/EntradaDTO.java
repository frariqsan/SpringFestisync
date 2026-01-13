package es.severo.festisync.dto;

import es.severo.festisync.entities.EntradaTipo;

import java.math.BigDecimal;

public record EntradaDTO(Integer id, EntradaTipo type, double precio) {
}
