package com.ibm.practica.spital.DTOs;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class Reservation {
    private String id;
    private String pacientID;
    private LocalDateTime reservationDate;
    private String specialization;
}
