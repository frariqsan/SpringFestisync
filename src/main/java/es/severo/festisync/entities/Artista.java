package es.severo.festisync.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "artista")
public class Artista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_artista")
    private Integer id;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "genero_musical", nullable = false)
    private String generoMusical;
    @Column(name = "pais", nullable = false)
    private String pais;
    @ManyToMany(mappedBy = "artistas")
    private Set<Evento> eventos;

}

