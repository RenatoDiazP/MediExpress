package com.example.ventas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ventas.model.Detalle;
import com.example.ventas.repository.DetalleRepository;

@Service
public class DetalleService 
{

    @Autowired
    public DetalleRepository detalleRepository;

    public List<Detalle> findAll()
    {
        return detalleRepository.findAll();
    }

    public Optional<Detalle> findById(Long id)
    {
        return detalleRepository.findById(id);
    }

    public List<Detalle> findByVentaId(Long ventaId)
    {
        return detalleRepository.findByVentaId(ventaId);
    }

    public Detalle save(Detalle detalle)
    {
        return detalleRepository.save(detalle);
    }

    public void delete(Long id)
    {
        detalleRepository.deleteById(id);
    }
}
