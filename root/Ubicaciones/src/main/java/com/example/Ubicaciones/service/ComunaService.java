package com.example.Ubicaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Ubicaciones.model.Comunas;
import com.example.Ubicaciones.repository.ComunaRepository;

@Service
public class ComunaService
{
    @Autowired
    public ComunaRepository comunaRepository;

    public List<Comunas> findAll()
    {
        return comunaRepository.findAll();
    }

    public Optional<Comunas> findById(Long Id)
    {
        return comunaRepository.findById(Id);
    }

    public Comunas save(Comunas comuna)
    {
        return comunaRepository.save(comuna);
    }

    public void deleteById(Long Id)
    {
        comunaRepository.deleteById(Id);
    }
}
