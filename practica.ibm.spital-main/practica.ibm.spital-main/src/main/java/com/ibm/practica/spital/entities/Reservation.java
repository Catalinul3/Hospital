package com.ibm.practica.spital.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name="reservation")
public class Reservation {
    @Id
    @NotNull
    @Column(name="ID")
    private String id;

    @NotNull
    @Column(name="Pacient")
    private String pacientID;
    @NotNull
    @Column(name="reservation date")
    private LocalDateTime time;
    @NotNull
    @Column(name="specialization")
    private String specialization;

}
