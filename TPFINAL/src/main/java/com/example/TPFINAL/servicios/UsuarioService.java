package com.example.TPFINAL.servicios;

import com.example.TPFINAL.modelos.Usuarios;
import com.example.TPFINAL.repositorios.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepo usuarioRepo;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    public Optional<Usuarios> buscarPorMail(String mail) {
        return usuarioRepo.findByMail(mail);
    }

    public Usuarios registrarUsuario(Usuarios usuario) {
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        return usuarioRepo.save(usuario);
    }
}