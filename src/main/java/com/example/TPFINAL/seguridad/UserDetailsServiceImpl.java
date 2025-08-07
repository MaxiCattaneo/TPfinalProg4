package com.example.TPFINAL.seguridad;

import com.example.TPFINAL.modelos.Usuarios;
import com.example.TPFINAL.repositorios.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepo usuarioRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuarios usuario = usuarioRepo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con Username: " + username));

        return new User(
        	    usuario.getUsername(),
        	    usuario.getPassword(),
        	    List.of(new SimpleGrantedAuthority("ROLE_" + usuario.getRol())) // ejemplo: ROLE_ADMIN
        	);    }
}
