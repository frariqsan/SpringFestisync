package es.severo.festisync.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "lugar")
public class Lugar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_lugar")
    private Integer id;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "ciudad", nullable = false)
    private String ciudad;
    @Column(name = "aforo")
    private int aforo;
}
