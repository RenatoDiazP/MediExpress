package com.mediexpress.resenas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mediexpress.resenas.model.Resena;
import com.mediexpress.resenas.repository.ResenaRepository;

@Service
public class ResenaServiceImpl implements ResenaService{
    @Autowired
    private ResenaRepository resenaRepository;

    @Override
    public List<Resena> findAll() {
        return resenaRepository.findAll();
    }

    @Override
    public Optional<Resena> findById(Long id) {
        return resenaRepository.findById(id);
    }

    @Override
    public List<Resena> findByProductoId(Long idProd) {
        return resenaRepository.findByProductoId(idProd);
    }

    @Override
    public Resena save(Resena resena) {
        return resenaRepository.save(resena);
    }

    @Override
    public void deleteById(Long id) {
        resenaRepository.deleteById(id);
    }

    @Override
    public double calcularReputacion(Long idProducto) {
        List<Resena> resenas = resenaRepository.findByProductoId(idProducto);
        if (resenas.isEmpty()) return 0.0;

        double suma = 0.0;
        for (Resena r : resenas) {
            suma += r.getCalificacion();
        }
        return suma / resenas.size(); // promedio
    }
}
