package com.ibm.practica.spital.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "section")
public class Section {
    @Id
    @NotNull
    @Column(name = "ID")
    public String id;
    @NotNull
    @Column(name = "departament")
    public String specializationName;
    @NotNull
    @Column(name = "number of available doctors")
    public int numberOfDoctors;
    @NotNull
    @Column(name = "number of available pacients")
    public int numberOfPacients;
}
