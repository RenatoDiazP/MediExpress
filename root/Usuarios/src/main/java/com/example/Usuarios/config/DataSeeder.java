package com.example.Usuarios.config;

import com.example.Usuarios.model.Estado;
import com.example.Usuarios.model.Rol;
import com.example.Usuarios.repository.EstadoRepository;
import com.example.Usuarios.repository.RolRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataSeeder implements CommandLineRunner
{

    private final EstadoRepository estadoRepository;
    private final RolRepository rolRepository;

    public DataSeeder(EstadoRepository estadoRepository, RolRepository rolRepository)
    {
        this.estadoRepository = estadoRepository;
        this.rolRepository = rolRepository;
    }

    @Override
    public void run(String... args)
    {
        preloadEstados();
        preloadRoles();
    }

    private void preloadEstados()
    {
        if (estadoRepository.count() == 0)
        {
            List<Estado> estados = List.of
            (
                new Estado(null, "ACTIVO"),
                new Estado(null, "INACTIVO")
            );
            estadoRepository.saveAll(estados);
        }
    }

    private void preloadRoles()
    {
        if (rolRepository.count() == 0)
        {
            List<Rol> roles = List.of
            (
                new Rol(null, "ADMIN"),
                new Rol(null, "USUARIO")
            );
            rolRepository.saveAll(roles);
        }
    }
}
