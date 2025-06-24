package com.example.Ubicaciones.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Ubicaciones.model.Regiones;

@Repository
public interface RegionRepository extends JpaRepository<Regiones, Long>
{

}
