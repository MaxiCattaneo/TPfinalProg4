package com.example.TPFINAL.controladores;

import com.example.TPFINAL.modelos.Reservas;
import com.example.TPFINAL.servicios.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    private final ReservaService reservaService;

    @Autowired
    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @PostMapping
    public ResponseEntity<Reservas> crearReserva(@RequestBody Reservas reserva) {
        return ResponseEntity.ok(reservaService.crearReserva(reserva));
    }

    @GetMapping
    public ResponseEntity<List<Reservas>> obtenerTodas() {
        return ResponseEntity.ok(reservaService.TodasLasReservas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Reservas>> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(reservaService.ReservasPorUsuario(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarReserva(@PathVariable Long id) {
        reservaService.cancelarReserva(id);
        return ResponseEntity.noContent().build();
    }
}