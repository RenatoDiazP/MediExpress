package com.example.Ubicaciones.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Ubicaciones.model.Direccion;

@Repository
public interface DireccionRepository extends JpaRepository<Direccion, Long>
{

}