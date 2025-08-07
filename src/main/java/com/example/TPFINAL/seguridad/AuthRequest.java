package com.example.TPFINAL.seguridad;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthRequest {
    private String Username;
    private String password;
}
