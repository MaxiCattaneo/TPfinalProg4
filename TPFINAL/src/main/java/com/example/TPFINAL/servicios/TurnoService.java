package com.example.TPFINAL.servicios;

import com.example.TPFINAL.modelos.Turno;
import com.example.TPFINAL.repositorios.TurnoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TurnoService {
    @Autowired
    private TurnoRepo turnoRepo;

    public List<Turno> listarTurnos() {
        return turnoRepo.findAllByOrderByHoraInicioAsc();
    }
}