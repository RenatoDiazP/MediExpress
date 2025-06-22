package com.mediexpress.incidencias_postventa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mediexpress.incidencias_postventa.model.Incidencia;
import com.mediexpress.incidencias_postventa.repository.IncidenciaRepository;

@Service
public class IncidenciaServiceImpl implements IncidenciaService {
    @Autowired
    private IncidenciaRepository incidenciaRepository;

    @Override
    public List<Incidencia> findAll() {
        return incidenciaRepository.findAll();
    }

    @Override
    public Optional<Incidencia> findById(Long id) {
        return incidenciaRepository.findById(id);
    }

    @Override
    public Incidencia save(Incidencia incidencia) {
        return incidenciaRepository.save(incidencia);
    }

    @Override
    public void deleteById(Long id) {
        incidenciaRepository.deleteById(id);
    }
}
