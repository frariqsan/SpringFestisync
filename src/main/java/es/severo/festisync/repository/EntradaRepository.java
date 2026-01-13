package es.severo.festisync.repository;

import es.severo.festisync.entities.Entrada;
import es.severo.festisync.entities.EntradaTipo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

public interface EntradaRepository extends JpaRepository<Entrada, Integer> {

    Page<Entrada> findByTipo(EntradaTipo tipo, Pageable pageable);

    //FINDBYPRICE
    Page<Entrada> findByPrecioLessTh(double precioMax, Pageable pageable);

}
