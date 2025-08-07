package com.example.TPFINAL.controladores;

import com.example.TPFINAL.modelos.Canchas;
import com.example.TPFINAL.modelos.Complejos;
import com.example.TPFINAL.repositorios.CanchaRepo;
import com.example.TPFINAL.repositorios.ComplejoRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/complejos")
@CrossOrigin(origins = "http://localhost:4200")
public class ComplejoController {

    @Autowired
    private ComplejoRepo complejoRepo;

    @Autowired
    private CanchaRepo canchaRepo;

    @GetMapping
    public List<Complejos> listarComplejos() {
        return complejoRepo.findAll();
    }
    
    @GetMapping("/{id}/canchas")
    public List<Canchas> listarCanchasPorComplejo(@PathVariable Long id) {
        return canchaRepo.findByComplejosId(id);
    }
}
