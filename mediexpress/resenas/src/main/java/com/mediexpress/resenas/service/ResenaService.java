package com.mediexpress.resenas.service;

import java.util.List;
import java.util.Optional;

import com.mediexpress.resenas.model.Resena;

public interface ResenaService {
    List<Resena> findAll();
    Optional<Resena> findById(Long id);
    List<Resena> findByProductoId(Long idProd);
    Resena save(Resena resena);
    void deleteById(Long id);
}
