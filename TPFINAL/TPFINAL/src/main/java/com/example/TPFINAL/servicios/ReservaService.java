package com.example.TPFINAL.servicios;

import com.example.TPFINAL.modelos.*;
import com.example.TPFINAL.repositorios.ReservaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
public class ReservaService {
    @Autowired
    private ReservaRepo reservaRepo;
    
    @Autowired
    private CanchaService canchaService;

    @Transactional
    public Reserva crearReserva(Reserva reserva) {
        // Uso la funcion del otro service para ver las canchas disponibles y relleno el booleano 
        boolean disponible = canchaService.CanchasDisponibles(
            reserva.getCancha().getComplejo().getId(),
            reserva.getFecha(),
            reserva.getTurno().getId()
        ).contains(reserva.getCancha());

        if (!disponible) {
            throw new IllegalStateException("La cancha no está disponible en ese horario");
        }
        
        return reservaRepo.save(reserva);
    }

    public List<Reserva> listarReservasPorUsuario(Long usuarioId) {
        return reservaRepo.findByUsuarioId(usuarioId);
    }

    @Transactional
    public void cancelarReserva(Long reservaId) {
        reservaRepo.deleteById(reservaId);
    }
}