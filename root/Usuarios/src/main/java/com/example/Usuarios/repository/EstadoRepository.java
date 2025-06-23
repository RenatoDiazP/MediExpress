package com.example.Usuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Usuarios.model.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long>
{
    
}
