package com.example.TPFINAL.servicios;

import com.example.TPFINAL.modelos.Cancha;
import com.example.TPFINAL.repositorios.CanchaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class CanchaService {
    @Autowired
    private CanchaRepo canchaRepo;

    public List<Cancha> CanchasPorComplejo(Long complejoId) {
        return canchaRepo.findByComplejoId(complejoId);
    }

    public List<Cancha> CanchasDisponibles(Long complejoId, LocalDate fecha, Long turnoId) {
        return canchaRepo.findCanchasDisponibles(complejoId, fecha, turnoId);
    }
}