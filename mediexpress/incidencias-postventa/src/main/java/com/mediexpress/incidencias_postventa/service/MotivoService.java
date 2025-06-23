package com.mediexpress.incidencias_postventa.service;

import java.util.List;

import com.mediexpress.incidencias_postventa.model.Motivo;

public interface MotivoService {
    List<Motivo> findAll();
    Motivo findById(Long id);
    Motivo save(Motivo motivo);
    void deleteById(Long id);
}
