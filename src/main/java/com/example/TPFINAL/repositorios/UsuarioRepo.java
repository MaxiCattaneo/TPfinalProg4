package com.example.TPFINAL.repositorios;

import com.example.TPFINAL.modelos.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepo extends JpaRepository<Usuarios, Long> {
    Optional<Usuarios> findByUsername(String username);
}