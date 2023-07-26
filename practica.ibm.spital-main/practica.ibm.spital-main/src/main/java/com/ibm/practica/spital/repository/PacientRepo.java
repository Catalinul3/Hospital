package com.ibm.practica.spital.repository;

import com.ibm.practica.spital.entities.Pacient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacientRepo extends JpaRepository<Pacient,String> {
}
