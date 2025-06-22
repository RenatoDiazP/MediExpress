package com.mediexpress.incidencias_postventa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mediexpress.incidencias_postventa.model.Incidencia;
import com.mediexpress.incidencias_postventa.service.IncidenciaService;

@RestController
@RequestMapping("api/incidencias")
public class IncidenciaController {
    @Autowired
    private IncidenciaService incidenciaService;

    @GetMapping
    public List<Incidencia> getAll() {
        return incidenciaService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Incidencia> getById(@PathVariable Long id) {
        return incidenciaService.findById(id);
    }

    @PostMapping
    public Incidencia create(@RequestBody Incidencia incidencia) {
        return incidenciaService.save(incidencia);
    }

    @PutMapping("/{id}")
    public Incidencia update(@PathVariable Long id, @RequestBody Incidencia updated) {
        updated.setIdIncidencia(id);
        return incidenciaService.save(updated);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        incidenciaService.deleteById(id);
    }
}
