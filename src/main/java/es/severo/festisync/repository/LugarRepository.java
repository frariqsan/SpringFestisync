package es.severo.festisync.repository;

import es.severo.festisync.entities.Lugar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LugarRepository extends JpaRepository<Lugar, Integer> {
}
