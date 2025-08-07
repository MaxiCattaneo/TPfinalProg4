package com.example.TPFINAL.modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "canchas")
public class Canchas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private double precioPorHora;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "complejo_id")
    @JsonBackReference


    private Complejos complejos;  // Este nombre debe coincidir con el "mappedBy" en Complejo
}