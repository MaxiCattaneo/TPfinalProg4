package com.example.TPFINAL.modelos;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "usuarios")  
public class Usuarios {

    @Id
    private Long id;

    private String username;

    private String mail;

    private String password;

    private String nombre;

    @Enumerated(EnumType.STRING)
    private Rol rol; 

    @OneToMany(mappedBy = "usuarios", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Reservas> reservas;

    public enum Rol {
        ADMIN,
        USER
    }
}
