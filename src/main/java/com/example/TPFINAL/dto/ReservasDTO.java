package com.example.TPFINAL.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservasDTO {
    private Long id;
    private LocalDate fecha;
    private String nombreUsuario;
    private String nombreCancha;
    private String nombreComplejo;
    private LocalTime horaInicio;
}
