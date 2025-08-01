package com.example.TPFINAL.servicios;

import com.example.TPFINAL.modelos.Complejo;
import com.example.TPFINAL.repositorios.ComplejoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ComplejoService {
    @Autowired
    private ComplejoRepo complejoRepo;

    public List<Complejo> listarComplejos() {
        return complejoRepo.findAll();
    }

    public Complejo buscarPorId(Long id) {
        return complejoRepo.findById(id).orElse(null);
    }
}