package com.mediexpress.producto_inventario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mediexpress.producto_inventario.model.Fila;
import com.mediexpress.producto_inventario.repository.FilaRepository;

@Service
public class FilaService {
    @Autowired
    private FilaRepository filaRepository;

    public List<Fila> obtenerTodas() {
        return filaRepository.findAll();
    }

    public Fila obtenerPorId(Long id) {
        return filaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fila no encontrada"));
    }

    public Fila crear(Fila fila) {
        return filaRepository.save(fila);
    }

    public Fila actualizar(Long id, Fila filaActualizada) {
        Fila fila = obtenerPorId(id);
        fila.setCodigo(filaActualizada.getCodigo());
        fila.setEstante(filaActualizada.getEstante());
        return filaRepository.save(fila);
    }

    public void eliminar(Long id) {
        filaRepository.deleteById(id);
    }
}
