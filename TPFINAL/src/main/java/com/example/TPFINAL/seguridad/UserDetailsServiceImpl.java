package com.example.TPFINAL.seguridad;

import com.example.TPFINAL.modelos.Usuarios;
import com.example.TPFINAL.repositorios.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepo usuarioRepo;

    @Override
    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
        Usuarios usuario = usuarioRepo.findByMail(mail)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con mail: " + mail));

        return new User(usuario.getMail(), usuario.getPassword(), Collections.emptyList());
    }
}
