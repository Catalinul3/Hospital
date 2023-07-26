package com.ibm.practica.spital.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pacient")
public class Pacient {
    @Id
    @NotNull
    @Column(name = "ID")
    private String pacientID;
    @NotNull
    @Column(name = "first_name")
    private String firstName;
    @NotNull
    @Column(name = "last_name")
    private String lastName;
    @NotNull
    @Column(name = "age")
    private int age;
    //Specializare
    @NotNull
    @Column(name = "issues")
    private String issues;

    //UserInfo
}
