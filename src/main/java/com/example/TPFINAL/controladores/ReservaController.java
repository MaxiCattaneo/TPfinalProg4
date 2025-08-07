package com.example.TPFINAL.controladores;


import com.example.TPFINAL.dto.ReservasDTO;
import com.example.TPFINAL.modelos.Reservas;
import com.example.TPFINAL.servicios.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/reservas")
@CrossOrigin(origins = "http://localhost:4200")
public class ReservaController {

    private final ReservaService reservaService;

    @Autowired
    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public ResponseEntity<List<ReservasDTO>> obtenerTodas() {
        List<ReservasDTO> reservas = reservaService.TodasLasReservas()
                .stream()
                .map(reservaService::convertirAReservaDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(reservas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<ReservasDTO>> obtenerPorId(@PathVariable Long id) {
        List<ReservasDTO> reservas = reservaService.ReservasPorUsuario(id)
                .stream()
                .map(reservaService::convertirAReservaDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(reservas);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarReserva(@PathVariable Long id) {
        reservaService.cancelarReserva(id);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/consultarReserva/{id}")
    public ResponseEntity<ReservasDTO> obtenerReservaPorId(@PathVariable Long id) {
        Reservas reserva = reservaService.buscarReservaPorId(id);
        if (reserva == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(reservaService.convertirAReservaDTO(reserva));
    }
    
}
