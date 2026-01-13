package es.severo.festisync.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "evento")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_evento")
    private Integer id;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;
    @ManyToOne
    @JoinColumn(name = "id_lugar",  nullable = false)
    private Lugar lugar;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "evento_has_artista",
            joinColumns = @JoinColumn(name = "evento_has_id"),
            inverseJoinColumns = @JoinColumn(name = "artista_has_id")
    )
    private Set<Artista> artistas;
}
