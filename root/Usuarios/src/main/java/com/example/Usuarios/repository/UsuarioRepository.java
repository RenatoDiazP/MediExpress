package com.example.Usuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Usuarios.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> 
{
    
}
