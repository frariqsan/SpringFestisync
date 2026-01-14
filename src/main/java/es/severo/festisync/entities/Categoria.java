package es.severo.festisync.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
//NamedQuery realizado
@NamedQuery(
        name = "Categoria.findByName",
        query = "SELECT c FROM Categoria c WHERE c.nombre = :name"
)
@Table(name = "categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Integer id;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @ManyToOne
    @JoinColumn(name = "id_evento", nullable = false)
    private Evento evento;
}
