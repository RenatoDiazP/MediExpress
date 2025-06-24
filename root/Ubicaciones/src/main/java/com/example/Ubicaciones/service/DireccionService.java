package com.example.Ubicaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Ubicaciones.model.Direccion;
import com.example.Ubicaciones.repository.DireccionRepository;

@Service
public class DireccionService
{
    @Autowired
    public DireccionRepository direccionRepository;

    public List<Direccion> findAll()
    {
        return direccionRepository.findAll();
    }

    public Optional<Direccion> findById(Long id)
    {
        return direccionRepository.findById(id);
    }

    public Direccion save(Direccion direccion)
    {
        return direccionRepository.save(direccion);
    }

    public void deleteById(Long id)
    {
        direccionRepository.deleteById(id);
    }
}
