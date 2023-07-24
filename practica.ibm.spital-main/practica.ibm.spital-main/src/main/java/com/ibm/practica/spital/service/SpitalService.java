package com.ibm.practica.spital.service;

import com.ibm.practica.spital.DTOs.AddReservation;
import com.ibm.practica.spital.DTOs.Pacients;
import com.ibm.practica.spital.DTOs.Reservation;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.naming.spi.ResolveResult;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    public Reservation getReservation(){
        log.info("SpitalService.getReservation() retrieving all reservations...");
        Reservation p = new Reservation();
        p.setId("12");
        p.setPacientID("12313");
        return p;
    }
    public List<Reservation> getReservationForPacient(String pacientID){
        log.info("SpitalService.getReservations() retrieving all reservations...");
        Reservation p = new Reservation();
        p.setId("12");
        p.setPacientID("12313");
        Reservation p1 = new Reservation();
        p1.setPacientID("12314");
        p1.setId("123");
        List<Reservation> list = new ArrayList<>();
        list.add(p);
        list.add(p1);

        return list.stream().filter(r -> r.getPacientID().equals(pacientID)).collect(Collectors.toList());
    }

    public boolean addReservation(AddReservation reservation){
        return true;
    }

    public boolean deleteReservation(String reservationID){
        return false;
    }
    public Reservation editReservation(String id,String spec,LocalDateTime time)
    {  List<Reservation>list=getAllReservations();
        Reservation newReservation=new Reservation();
       /* for(Reservation reservation:list)
        {
            if(reservation.getId().equals(id))
            {reservation.setReservationDate(time);
              reservation.setSpecialization(spec);
              newReservation=reservation;
            }
        }
        Old Style*/
        newReservation=list.stream().filter(reservation -> id.equals(reservation.getId()))
                .findAny().orElse(null);
        if(newReservation!=null)
        {
            newReservation.setReservationDate(time);
            newReservation.setSpecialization(spec);
        }
        return newReservation;
    }
}

