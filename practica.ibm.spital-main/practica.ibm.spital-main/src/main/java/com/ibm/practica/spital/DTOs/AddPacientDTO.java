package com.ibm.practica.spital.DTOs;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper=true)
public class AddPacientDTO extends Pacients{

    private String cnp;

}
