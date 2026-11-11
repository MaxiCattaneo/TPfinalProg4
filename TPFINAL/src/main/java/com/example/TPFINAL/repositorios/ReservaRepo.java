package com.example.TPFINAL.repositorios;

import com.example.TPFINAL.modelos.Canchas;
import com.example.TPFINAL.modelos.Reservas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservaRepo extends JpaRepository<Reservas, Long> {
    
    // Busco las reservas de un usuario en particular 
    List<Reservas> findByUsuariosId(Long usuariosId);
    
    // Validacion para saber si la cancha esta disponible
    List<Reservas> findByCanchaAndFechaAndTurnoId(Canchas cancha, LocalDate fecha, Long turnosId);
}