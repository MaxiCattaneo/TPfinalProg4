package com.example.TPFINAL.modelos;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "turnos")
public class Turnos {

    @Id
    private Long id;
    private LocalTime horaInicio;  // Ej: 17:00
    private LocalTime horaFin;    // Ej: 18:00 (siempre 1 hora después)
 
    }