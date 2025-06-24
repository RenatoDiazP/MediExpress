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

import com.example.Ubicaciones.model.Direccion;
import com.example.Ubicaciones.service.DireccionService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/direcciones")
public class DireccionController
{
    @Autowired
    public DireccionService direccionService;

    @GetMapping
    @Operation(summary = "Genera una lista con todas las direcciones")
    public List<Direccion> getAll()
    {
        return direccionService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca una direccion por ID")
    public ResponseEntity<Direccion> getById(@PathVariable Long id)
    {
        return direccionService.findById(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Guarda una direccion nueva")
    public Direccion create(@RequestBody Direccion direccion)
    {
        return direccionService.save(direccion);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualiza una direccion, buscandola por el ID")
    public ResponseEntity<Direccion> update(@PathVariable Long id, @RequestBody Direccion direccion)
    {
        if(!direccionService.findById(id).isPresent())
        {
            return ResponseEntity.notFound().build();
        }
        direccion.setId(id);
        return ResponseEntity.ok(direccionService.save(direccion));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Borra una direccion, buscandola por el ID")
    public ResponseEntity<Void> delete(@PathVariable Long id)
    {
        if(!direccionService.findById(id).isPresent())
        {
            return ResponseEntity.notFound().build();
        }
        direccionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
