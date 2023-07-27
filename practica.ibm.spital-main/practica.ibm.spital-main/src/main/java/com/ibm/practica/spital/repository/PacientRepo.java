package com.ibm.practica.spital.repository;

import com.ibm.practica.spital.entities.Pacient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PacientRepo extends JpaRepository<Pacient,String> {
    @Modifying
    @Query(value ="DELETE FROM pacient WHERE pacient_id = ?1", nativeQuery = true)
    int deletePacient(String pacientID);
}
