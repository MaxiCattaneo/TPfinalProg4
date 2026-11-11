package com.example.TPFINAL.repositorios;

import com.example.TPFINAL.modelos.Complejos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplejoRepo extends JpaRepository<Complejos, Long> {
    // Consultas personalizadas si las necesitas
}