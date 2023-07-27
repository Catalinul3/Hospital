package com.ibm.practica.spital.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddSectionDTO {
    private String id;
    private String specializationName;
    private int numberOfDoctors;
    private int numberOfPacients;
}
