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

import com.mediexpress.incidencias_postventa.model.Estado;
import com.mediexpress.incidencias_postventa.service.EstadoService;

@RestController
@RequestMapping("/api/estado")
public class EstadoController {
    @Autowired
    private EstadoService estadoService;

    @GetMapping
    public List<Estado> getAll() {
        return estadoService.findAll();
    }

    @GetMapping("/{id}")
    public Estado getById(@PathVariable Long id) {
        return estadoService.findById(id);
    }

    @PostMapping
    public Estado create(@RequestBody Estado estado) {
        return estadoService.save(estado);
    }

    @PutMapping("/{id}")
    public Estado update(@PathVariable Long id, @RequestBody Estado estado) {
        estado.setIdEstado(id);
        return estadoService.save(estado);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        estadoService.deleteById(id);
    }
}
