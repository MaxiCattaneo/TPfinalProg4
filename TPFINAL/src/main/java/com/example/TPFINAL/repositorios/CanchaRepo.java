package com.example.TPFINAL.repositorios;

import com.example.TPFINAL.modelos.Cancha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface CanchaRepo extends JpaRepository<Cancha, Long> {
    
    // Ver las canchas por complejos
    List<Cancha> findByComplejoId(Long complejoId);
    
    // Query para ver las canchas que tengo disponibles, es decir que no existe su turno en las reservas 
    @Query("SELECT c FROM Cancha c WHERE c.complejo.id = :complejoId AND " +
           "NOT EXISTS (SELECT r FROM Reserva r WHERE r.cancha = c AND " +
           "r.fecha = :fecha AND r.turno.id = :turnoId)")
    List<Cancha> findCanchasDisponibles(
        @Param("complejoId") Long complejoId,
        @Param("fecha") LocalDate fecha,
        @Param("turnoId") Long turnoId
    );
}