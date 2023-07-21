package com.ibm.practica.spital.service;

import com.ibm.practica.spital.DTOs.Pacients;
import com.ibm.practica.spital.DTOs.Reservation;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
public class SpitalService {
    public List<Pacients> getAllPacients()
    {log.info("Service called getAllPacients");
        Pacients p= new Pacients();
        p.setPacientID("123");
        p.setFirstName("Catalin");
        Pacients p2=new Pacients();
        p2.setPacientID("456");
        p2.setFirstName("Constantin");
        return List.of(p);
    }
    public List<Reservation>getAllReservations()
    {
        log.info("Service called getAllPacients");
        Reservation r= new Reservation();
        r.setId("123");
        r.setSpecialization("IDk");
        Pacients p2=new Pacients();
        p2.setPacientID("456");
        p2.setFirstName("Constantin");
        return List.of(r);
    }
}
