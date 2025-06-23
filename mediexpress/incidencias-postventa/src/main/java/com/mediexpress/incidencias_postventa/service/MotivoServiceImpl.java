package com.mediexpress.incidencias_postventa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mediexpress.incidencias_postventa.model.Motivo;
import com.mediexpress.incidencias_postventa.repository.MotivoRepository;

@Service
public class MotivoServiceImpl implements MotivoService {
    @Autowired
    private MotivoRepository motivoRepository;

    @Override
    public List<Motivo> findAll() {
        return motivoRepository.findAll();
    }

    @Override
    public Motivo findById(Long id) {
        return motivoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Motivo no encontrado"));
    }

    @Override
    public Motivo save(Motivo motivo) {
        return motivoRepository.save(motivo);
    }

    @Override
    public void deleteById(Long id) {
        motivoRepository.deleteById(id);
    }
}
