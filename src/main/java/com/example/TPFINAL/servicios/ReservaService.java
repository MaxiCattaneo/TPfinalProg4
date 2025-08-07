package com.example.TPFINAL.servicios;


import com.example.TPFINAL.dto.ReservasDTO;
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

    @Autowired
    private ReservaRepo reservasRepository;

    @Transactional
    public Reservas crearReserva(Reservas reserva) {
        // Buscar el usuario completo por username antes de guardar
        String username = reserva.getUsuarios().getUsername();
        Usuarios usuarioCompleto = usuarioRepo.findByUsername(username)
            .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));

        reserva.setUsuarios(usuarioCompleto);

        boolean disponible = canchaService.CanchasDisponibles(
                reserva.getCancha().getComplejos().getId(),
                reserva.getFecha(),
                reserva.getTurno().getId()
        ).contains(reserva.getCancha());

        if (!disponible) {
            throw new IllegalStateException("La cancha no está disponible en ese horario");
        }

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
        ReservasDTO dto = new ReservasDTO();
        dto.setId(reserva.getId());
        dto.setFecha(reserva.getFecha());
        dto.setNombreUsuario(reserva.getUsuarios().getNombre()); // nombre del usuario
        dto.setNombreCancha(reserva.getCancha().getNombre()); // nombre cancha
        dto.setNombreComplejo(reserva.getCancha().getComplejos().getNombre()); // nombre complejo
        dto.setHoraInicio(reserva.getTurno().getHoraInicio()); // horaInicio del turno
        return dto;
    }

    @Transactional
    public void cancelarReserva(Long reservaId) {
        reservaRepo.deleteById(reservaId);
    }
}
