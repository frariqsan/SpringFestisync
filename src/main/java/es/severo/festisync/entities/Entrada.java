package es.severo.festisync.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "entrada")
public class Entrada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_entrada")
    private Integer id;
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", nullable = false)
    private EntradaTipo tipo;
    @Column(name = "precio", nullable = false)
    private BigDecimal precio;
    @ManyToOne
    @JoinColumn(name = "id_evento", nullable = false)
    private Evento evento;
}
