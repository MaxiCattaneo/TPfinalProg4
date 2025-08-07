package com.example.TPFINAL.repositorios;

import com.example.TPFINAL.modelos.Canchas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface CanchaRepo extends JpaRepository<Canchas, Long> {
    
    // Ver las canchas por complejos
    List<Canchas> findByComplejosId(Long complejosId);
    
    // Query para ver las canchas que tengo disponibles, es decir que no existe su turno en las reservas 
    @Query("SELECT c FROM Canchas c WHERE c.complejos.id = :complejoId AND " +
           "NOT EXISTS (SELECT r FROM Reservas r WHERE r.cancha = c AND " +
           "r.fecha = :fecha AND r.turno.id = :turnoId)")
    List<Canchas> findCanchasDisponibles(
        @Param("complejoId") Long complejosId,
        @Param("fecha") LocalDate fecha,
        @Param("turnoId") Long turnoId
    );
    Optional<Canchas> findByNombre(String nombre);

}