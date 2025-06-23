package com.mediexpress.incidencias_postventa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mediexpress.incidencias_postventa.model.Estado;
import com.mediexpress.incidencias_postventa.repository.EstadoRepository;

@Service
public class EstadoServiceImpl implements EstadoService {
    @Autowired
    private EstadoRepository estadoRepository;

    @Override
    public List<Estado> findAll() {
        return estadoRepository.findAll();
    }

    @Override
    public Estado findById(Long id) {
        return estadoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Estado no encontrado"));
    }

    @Override
    public Estado save(Estado estado) {
        return estadoRepository.save(estado);
    }

    @Override
    public void deleteById(Long id) {
        estadoRepository.deleteById(id);
    }
}
