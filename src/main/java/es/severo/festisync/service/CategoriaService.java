package es.severo.festisync.service;

import es.severo.festisync.entities.Artista;
import es.severo.festisync.entities.Categoria;
import es.severo.festisync.repository.CategoriaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Service
public class CategoriaService {
    private CategoriaRepository categoriaRepository;
    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public Page<Categoria> findAll(Pageable pageable) {
        return categoriaRepository.findAll(pageable);
    }
    public Page<Categoria> findByName(String name, Pageable pageable) {
        return categoriaRepository.findByName(name, pageable);
    }
    //CRUD
    public Optional<Categoria> findById(Integer id) {
        return categoriaRepository.findById(id);
    }
    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }
    public void delete(Integer id) {
        categoriaRepository.deleteById(id);
    }
}
