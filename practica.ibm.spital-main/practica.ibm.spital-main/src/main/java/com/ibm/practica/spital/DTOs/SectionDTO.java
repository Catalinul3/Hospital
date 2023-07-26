package com.ibm.practica.spital.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SectionDTO {
    public String id;
    public String specializationName;
    public int numberOfDoctors;
    public int numberOfPacients;
}
