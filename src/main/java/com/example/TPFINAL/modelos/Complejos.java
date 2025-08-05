package com.example.TPFINAL.modelos;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

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
    private List<Canchas> canchas;
}