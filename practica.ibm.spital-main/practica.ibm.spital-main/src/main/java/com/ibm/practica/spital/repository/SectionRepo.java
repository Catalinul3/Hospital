package com.ibm.practica.spital.repository;

import com.ibm.practica.spital.entities.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectionRepo extends JpaRepository<Section,String> {
}
