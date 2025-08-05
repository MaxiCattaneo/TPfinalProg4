package com.example.TPFINAL.modelos;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "canchas")
public class Cancha {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String superficie;
    private double precioPorHora;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "complejo_id")
    private Complejo complejo;  // Este nombre debe coincidir con el "mappedBy" en Complejo
}