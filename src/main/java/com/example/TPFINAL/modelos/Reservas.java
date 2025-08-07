package com.example.TPFINAL.modelos;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "reservas")
public class Reservas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto genera id
    private Long id;

    private LocalDate fecha;

    @ManyToOne(fetch = FetchType.EAGER)  // para evitar problemas de carga perezosa en REST
    @JoinColumn(name = "usuario_id", nullable = false)
    @JsonBackReference

    private Usuarios usuarios;
    
    public void setUsuario(Usuarios usuario) {
        this.usuarios = usuario;
    }

    public Usuarios getUsuario() {
        return usuarios;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cancha_id", nullable = false)
    @JsonBackReference
    private Canchas cancha;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "turno_id", nullable = false)
    @JsonBackReference
    private Turnos turno;
}
