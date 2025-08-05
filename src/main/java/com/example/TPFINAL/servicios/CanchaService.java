package com.example.TPFINAL.servicios;

import com.example.TPFINAL.modelos.Canchas;
import com.example.TPFINAL.repositorios.CanchaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class CanchaService {
    @Autowired
    private CanchaRepo canchaRepo;

    public List<Canchas> CanchasPorComplejo(Long complejosId) {
        return canchaRepo.findByComplejosId(complejosId);
    }

    public List<Canchas> CanchasDisponibles(Long complejosId, LocalDate fecha, Long turnoId) {
        return canchaRepo.findCanchasDisponibles(complejosId, fecha, turnoId);
    }
}