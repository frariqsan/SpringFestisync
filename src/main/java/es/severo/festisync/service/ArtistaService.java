package es.severo.festisync.service;

import es.severo.festisync.entities.Artista;
import es.severo.festisync.repository.ArtistaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;
@Service
public class ArtistaService {
    private final ArtistaRepository artistaRepository;

    public ArtistaService(ArtistaRepository artistaRepository) {
        this.artistaRepository = artistaRepository;
    }

    public Page<Artista> findAll(Pageable pageable) {
        return artistaRepository.findAll(pageable);
    }

    public Page<Artista> findByName(String name, Pageable pageable) {
        return artistaRepository.findByName(name, pageable);
    }

    public Optional<Artista> findById(Integer id) {
        return artistaRepository.findById(id);
    }

    public Artista save(Artista artista) {
        return artistaRepository.save(artista);
    }
    public void deleteById(Integer id) {
        artistaRepository.deleteById(id);
    }



}
