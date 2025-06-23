package com.mediexpress.incidencias_postventa.service;

import java.util.List;

import com.mediexpress.incidencias_postventa.model.Estado;

public interface EstadoService {
    List<Estado> findAll();
    Estado findById(Long id);
    Estado save(Estado estado);
    void deleteById(Long id);

}
