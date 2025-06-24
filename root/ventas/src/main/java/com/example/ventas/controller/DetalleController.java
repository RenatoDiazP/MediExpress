package com.example.ventas.controller;

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

import com.example.ventas.model.Detalle;
import com.example.ventas.service.DetalleService;

@RestController
@RequestMapping("/detalles")
public class DetalleController
{
    @Autowired
    public DetalleService detalleService;

    @GetMapping
    public List<Detalle> getAll()
    {
        return detalleService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Detalle> getById(@PathVariable Long id)
    {
        return detalleService.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/venta/{ventaId}")
    public List<Detalle> getByVenta(@PathVariable Long ventaId)
    {
        return detalleService.findByVentaId(ventaId);
    }

    @PostMapping
    public Detalle create(@RequestBody Detalle detalle)
    {
        return detalleService.save(detalle);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Detalle> update(@PathVariable Long id, @RequestBody Detalle detalle)
    {
        if (!detalleService.findById(id).isPresent())
        {
            return ResponseEntity.notFound().build();
        }
        detalle.setIdDetalle(id);
        return ResponseEntity.ok(detalleService.save(detalle));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id)
    {
        if (!detalleService.findById(id).isPresent())
        {
            return ResponseEntity.notFound().build();
        }
        detalleService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
