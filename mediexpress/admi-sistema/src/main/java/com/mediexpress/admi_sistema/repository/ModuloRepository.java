package com.mediexpress.admi_sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mediexpress.admi_sistema.model.Modulo;

@Repository
public interface ModuloRepository extends JpaRepository<Modulo, Long> {

}
