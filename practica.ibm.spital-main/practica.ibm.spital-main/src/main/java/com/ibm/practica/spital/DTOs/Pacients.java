package com.ibm.practica.spital.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Pacients {
    private String firstName;
    private String lastName;
    private int age;
    //Specializare
    private String issues;
    private String pacientID;

    //UserInfo


}