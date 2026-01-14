package es.severo.festisync.repository;

import es.severo.festisync.entities.Lugar;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LugarRepository extends JpaRepository<Lugar, Integer> {

    Page<Lugar> findAllByOrderByAforoDesc(Pageable pageable);
    @Query("SELECT a FROM Artista a WHERE a.nombre = :name")
    Page<Lugar> findByName(String name, Pageable pageable);
}
