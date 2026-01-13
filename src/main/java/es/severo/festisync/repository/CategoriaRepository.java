package es.severo.festisync.repository;

import es.severo.festisync.entities.Categoria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

    @Query("SELECT c FROM Categoria c WHERE c.nombre = :name")
    Page<Categoria> findByName(String name, Pageable pageable);

}
