package com.example.Ubicaciones.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Ubicaciones.model.Comunas;
import com.example.Ubicaciones.service.ComunaService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/comunas")
public class ComunaController
{
    @Autowired
    public ComunaService service;

    @GetMapping
    @Operation(summary = "Genera una lista de todas las comunas")
    public List<Comunas> getAll()
    {
        return service.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca una comuna por Id")
    public ResponseEntity<Comunas> getById(@PathVariable Long Id)
    {
        return service.findById(Id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Guarda una comuna nueva")
    public Comunas create(@RequestBody Comunas comuna)
    {
        return service.save(comuna);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualiza una comuna, buscandola por el ID")
    public ResponseEntity<Comunas> update(@PathVariable Long id, @RequestBody Comunas comuna)
    {
        if(!service.findById(id).isPresent())
        {
            return ResponseEntity.notFound().build();
        }
        comuna.setId(id);
        return ResponseEntity.ok(service.save(comuna));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Borra una comuna, buscandola por el ID")
    public ResponseEntity<Void> delete(@PathVariable Long id)
    {
        if(!service.findById(id).isPresent())
        {
            return ResponseEntity.notFound().build();
        }
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
