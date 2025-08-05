package com.example.TPFINAL.seguridad;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthRequest {
    private String mail;
    private String password;
}
