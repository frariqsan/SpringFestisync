package es.severo.festisync.service;

import es.severo.festisync.entities.Artista;
import es.severo.festisync.entities.Lugar;
import es.severo.festisync.repository.LugarRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class LugarService {
    private LugarRepository lugarRepository;
    public LugarService(LugarRepository lugarRepository) {
        this.lugarRepository = lugarRepository;
    }
    public Page<Lugar> findAll(Pageable pageable) {
        return lugarRepository.findAll(pageable);
    }
//Ciudad
    public Page<Lugar> findByName(String name, Pageable pageable) {
        return lugarRepository.findByName(name, pageable);
    }
//Aforo
    public Page<Lugar> findAllByOrderByAforoDesc(Pageable pageable) {
        return lugarRepository.findAllByOrderByAforoDesc(pageable);
    }




}
