package com.example.TPFINAL.controladores;

import com.example.TPFINAL.modelos.Turnos;
import com.example.TPFINAL.repositorios.TurnoRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/turnos")
@CrossOrigin(origins = "http://localhost:4200")
public class TurnoController {

    @Autowired
    private TurnoRepo turnoRepo;

    @GetMapping
    public List<Turnos> listarTurnos() {
        return turnoRepo.findAll();
    }
}
