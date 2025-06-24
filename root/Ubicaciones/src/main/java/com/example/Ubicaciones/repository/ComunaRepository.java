package com.example.Ubicaciones.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Ubicaciones.model.Comunas;

@Repository
public interface ComunaRepository extends JpaRepository<Comunas, Long>
{

}
