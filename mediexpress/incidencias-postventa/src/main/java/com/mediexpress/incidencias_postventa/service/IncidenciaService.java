package com.mediexpress.incidencias_postventa.service;

import java.util.List;


import com.mediexpress.incidencias_postventa.model.Incidencia;


public interface IncidenciaService {
    List<Incidencia> findAll();
    Incidencia findById(Long id);
    Incidencia save(Incidencia incidencia);
    void deleteById(Long id);
}
