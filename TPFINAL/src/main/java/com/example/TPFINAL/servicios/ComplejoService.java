package com.example.TPFINAL.servicios;

import com.example.TPFINAL.modelos.Complejos;
import com.example.TPFINAL.repositorios.ComplejoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ComplejoService {
    @Autowired
    private ComplejoRepo complejoRepo;

    public List<Complejos> listarComplejos() {
        return complejoRepo.findAll();
    }

    public Complejos buscarPorId(Long id) {
        return complejoRepo.findById(id).orElse(null);
    }
}