package com.example.TPFINAL.modelos;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "complejos")
public class Complejos {
    @Id
    private Long id;

    private String nombre;
    private String ubicacion;

    @OneToMany(mappedBy = "complejos", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference

    private List<Canchas> canchas;
}