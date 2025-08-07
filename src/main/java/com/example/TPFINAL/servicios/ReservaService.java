package com.example.TPFINAL.servicios;

import com.example.TPFINAL.dto.ReservasDTO;
import com.example.TPFINAL.dto.TomarReservasDTO;
import com.example.TPFINAL.modelos.*;
import com.example.TPFINAL.repositorios.CanchaRepo;
import com.example.TPFINAL.repositorios.ReservaRepo;
import com.example.TPFINAL.repositorios.TurnoRepo;
import com.example.TPFINAL.repositorios.UsuarioRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepo reservaRepo;

    @Autowired
    private CanchaService canchaService;

    @Autowired
    private UsuarioRepo usuarioRepo;

    @Autowired
    private CanchaRepo canchaRepo;

    @Autowired
    private TurnoRepo turnoRepo;

    @Transactional
    public Reservas crearReserva(TomarReservasDTO dto, String username) {
        // Obtener usuario desde el nombre de usuario (ya no se usa dto.getUsername())
        Usuarios usuario = usuarioRepo.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));

        // Obtener cancha
        Canchas cancha = canchaRepo.findById(dto.getCanchaId())
                .orElseThrow(() -> new IllegalArgumentException("Cancha no encontrada"));

        // Obtener turno
        Turnos turno = turnoRepo.findById(dto.getTurnoId())
                .orElseThrow(() -> new IllegalArgumentException("Turno no encontrado"));

        // Verificar disponibilidad de la cancha en la fecha y turno
        boolean disponible = canchaService.CanchasDisponibles(
                cancha.getComplejos().getId(),
                dto.getFecha(),
                turno.getId()
        ).stream().anyMatch(c -> c.getId().equals(cancha.getId()));

        if (!disponible) {
            throw new IllegalStateException("La cancha no está disponible en ese horario");
        }

        // Crear y guardar la reserva
        Reservas reserva = new Reservas();
        reserva.setUsuarios(usuario);
        reserva.setCancha(cancha);
        reserva.setTurno(turno);
        reserva.setFecha(dto.getFecha());

        return reservaRepo.save(reserva);
    }

    public List<Reservas> ReservasPorUsuario(Long usuarioId) {
        return reservaRepo.findByUsuariosId(usuarioId);
    }

    public List<Reservas> TodasLasReservas() {
        return reservaRepo.findAll();
    }

    public List<ReservasDTO> obtenerTodasComoDTO() {
        return reservaRepo.findAll()
                .stream()
                .map(this::convertirAReservaDTO)
                .collect(Collectors.toList());
    }

    public Reservas buscarReservaPorId(Long id) {
        return reservaRepo.findById(id).orElse(null);
    }

    public ReservasDTO convertirAReservaDTO(Reservas reserva) {
        return new ReservasDTO(
            reserva.getId(),
            reserva.getFecha(),
            reserva.getUsuarios().getNombre(),                     // nombreUsuario
            reserva.getCancha().getNombre(),                      // nombreCancha
            reserva.getCancha().getComplejos().getNombre(),        // nombreComplejo
            reserva.getTurno().getHoraInicio()                    // horaInicio
        );
    }


    @Transactional
    public void cancelarReserva(Long reservaId) {
        reservaRepo.deleteById(reservaId);
    }
}
