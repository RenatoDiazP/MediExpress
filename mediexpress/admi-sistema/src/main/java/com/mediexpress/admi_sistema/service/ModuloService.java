package com.mediexpress.admi_sistema.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mediexpress.admi_sistema.model.Modulo;
import com.mediexpress.admi_sistema.repository.ModuloRepository;


@Service
public class ModuloService {
    @Autowired
    private ModuloRepository moduloRepository;

    public List<Modulo> listar() {
        return moduloRepository.findAll();
    }

    public Modulo obtener(Long id) {
        return moduloRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Módulo no encontrado"));
    }

    public Modulo crear(Modulo m) {
        return moduloRepository.save(m);
    }

    public Modulo actualizar(Long id, Modulo datos) {
        Modulo m = obtener(id);
        m.setNombre(datos.getNombre());
        return moduloRepository.save(m);
    }

    public void eliminar(Long id) {
        moduloRepository.deleteById(id);
    }

}
