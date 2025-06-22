package com.mediexpress.incidencias_postventa.service;

import java.util.List;
import java.util.Optional;

import com.mediexpress.incidencias_postventa.model.Incidencia;


public interface IncidenciaService {
    List<Incidencia> findAll();
    Optional<Incidencia> findById(Long id);
    Incidencia save(Incidencia incidencia);
    void deleteById(Long id);
}
