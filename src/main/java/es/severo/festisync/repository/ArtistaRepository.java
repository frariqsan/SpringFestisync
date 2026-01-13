package es.severo.festisync.repository;

import es.severo.festisync.entities.Artista;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ArtistaRepository extends JpaRepository<Artista, Integer> {

    //Busca artistas por nombre
    @Query("SELECT a FROM Artista a WHERE a.nombre = :name")
    Page<Artista> findByName(String name, Pageable pageable);

    @Query("SELECT a FROM Artista a JOIN a.eventos e WHERE e.id = :eventoId")
    Page<Artista> findByEventoId(Integer eventoId, Pageable pageable);
}
