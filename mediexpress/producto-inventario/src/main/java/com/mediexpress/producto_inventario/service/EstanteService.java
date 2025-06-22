package com.mediexpress.producto_inventario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mediexpress.producto_inventario.model.Estante;
import com.mediexpress.producto_inventario.repository.EstanteRepository;

@Service
public class EstanteService {
    @Autowired
    private EstanteRepository estanteRepository;

    public List<Estante> obtenerTodos() {
        return estanteRepository.findAll();
    }

    public Estante obtenerPorId(Long id) {
        return estanteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estante no encontrado"));
    }

    public Estante crear(Estante estante) {
        return estanteRepository.save(estante);
    }

    public Estante actualizar(Long id, Estante estanteActualizado) {
        Estante estante = obtenerPorId(id);
        estante.setCodigo(estanteActualizado.getCodigo());
        return estanteRepository.save(estante);
    }

    public void eliminar(Long id) {
        estanteRepository.deleteById(id);
    }

    
}
