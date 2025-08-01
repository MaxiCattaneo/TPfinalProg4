package com.example.TPFINAL.repositorios;

import com.example.TPFINAL.modelos.Cancha;
import com.example.TPFINAL.modelos.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservaRepo extends JpaRepository<Reserva, Long> {
    
    // Busco las reservas de un usuario en particular 
    List<Reserva> findByUsuarioId(Long usuarioId);
    
    // Validacion para saber si la cancha esta disponible
    List<Reserva> findByCanchaAndFechaAndTurnoId(Cancha cancha, LocalDate fecha, Long turnoId);
}