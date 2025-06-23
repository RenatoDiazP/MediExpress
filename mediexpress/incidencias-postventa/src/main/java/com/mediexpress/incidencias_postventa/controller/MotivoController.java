package com.mediexpress.incidencias_postventa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mediexpress.incidencias_postventa.model.Motivo;
import com.mediexpress.incidencias_postventa.service.MotivoService;

@RestController
@RequestMapping("/api/motivo")
public class MotivoController {
    @Autowired
    private MotivoService motivoService;

    @GetMapping
    public List<Motivo> getAll() {
        return motivoService.findAll();
    }

    @GetMapping("/{id}")
    public Motivo getById(@PathVariable Long id) {
        return motivoService.findById(id);
    }

    @PostMapping
    public Motivo create(@RequestBody Motivo motivo) {
        return motivoService.save(motivo);
    }

    @PutMapping("/{id}")
    public Motivo update(@PathVariable Long id, @RequestBody Motivo motivo) {
        motivo.setIdMotivo(id);
        return motivoService.save(motivo);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        motivoService.deleteById(id);
    }
}

