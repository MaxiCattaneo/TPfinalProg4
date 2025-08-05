package com.example.TPFINAL.repositorios;

import com.example.TPFINAL.modelos.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TurnoRepo extends JpaRepository<Turno, Long> {
    List<Turno> findAllByOrderByHoraInicioAsc();
}