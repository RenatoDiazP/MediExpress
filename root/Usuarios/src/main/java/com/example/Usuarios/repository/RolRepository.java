package com.example.Usuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Usuarios.model.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long>
{

}
