package com.mediexpress.resenas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.mediexpress.resenas.model.Resena;
import com.mediexpress.resenas.repository.ResenaRepository;

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
        return resenaRepository.findByProductoIdProd(idProd);
    }

    @Override
    public Resena save(Resena resena) {
        return resenaRepository.save(resena);
    }

    @Override
    public void deleteById(Long id) {
        resenaRepository.deleteById(id);
    }
}
