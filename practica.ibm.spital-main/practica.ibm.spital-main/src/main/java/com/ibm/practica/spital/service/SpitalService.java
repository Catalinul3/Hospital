package com.ibm.practica.spital.service;

import com.ibm.practica.spital.DTOs.AddReservation;
import com.ibm.practica.spital.DTOs.Pacients;
import com.ibm.practica.spital.DTOs.Reservation;
import com.ibm.practica.spital.DTOs.Section;
import com.ibm.practica.spital.repository.PacientRepo;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import javax.naming.spi.ResolveResult;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Log4j2
public class SpitalService {
    private List<Section>sections;
    @Autowired
    PacientRepo pacientRepo;

    ModelMapper mapper=new ModelMapper();
    public List<Pacients> getAllPacients()
    {log.info("Service called getAllPacients");
       /* Pacients p= new Pacients();

        p.setFirstName("Catalin");
        Pacients p2=new Pacients();

        p2.setFirstName("Constantin");
        return List.of(p,p2); */
    return pacientRepo.findAll().stream().map(pacient -> mapper.map(pacient,Pacients.class))
            .collect(Collectors.toList());

    }

    public List<Reservation>getAllReservations()
    {
        log.info("Service called getAllPacients");
        Reservation r= new Reservation();
        r.setId("123");
        r.setSpecialization("IDk");
        Pacients p2=new Pacients();

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
    public List<Section> getAllSections()
    {
      /*  Section s=new Section();
        s.setId("C2");
        s.setSpecializationName("Cardiologie");
        s.setNumberOfDoctors(2);
        s.setNumberOfPacients(5);
        Section s2=new Section();
        s2.setId("N1");
        s2.setSpecializationName("Neurologie");
        s2.setNumberOfPacients(7);
        s2.setNumberOfDoctors(4);

        sections.add(s);
        sections.add(s2);*/
        return sections;
    }
    public ResponseEntity addSection(Section section)
    {   if(sections==null)
    {
        sections=new ArrayList<>();
    }
    else
    {
        sections=getAllSections();
    }
        if(section!=null)
        {
            sections.add(section);
            return ResponseEntity.ok(section.getSpecializationName()+" has been added");
        }
        return ResponseEntity.badRequest().body("Invalid section data. Section cannot be null.");
    }
    public Section editSection(String id,String name,int doctors, int pacients)
    {sections=getAllSections();
        Section newSection=new Section();
        newSection=sections.stream().filter(section -> id.equals(section.getId()))
                .findAny().orElse(null);
        if(newSection!=null)
        {
            newSection.setNumberOfDoctors(doctors);
            newSection.setNumberOfPacients(pacients);
            newSection.setSpecializationName(name);
        }
        return newSection;
    }
    public ResponseEntity deleteSection(String id)
    {
      sections=getAllSections();
        Section sectionToDelete=new Section();
        sectionToDelete=sections.stream().filter(section -> id.equals(section.getId()))
                .findAny().orElse(null);
        if(sectionToDelete!=null)
        {
            sections.remove(sectionToDelete);
            return ResponseEntity.ok("Delete section"+sectionToDelete.getSpecializationName());

        }
        return ResponseEntity.badRequest().body(" Invalid section data. Section cannot be null.");
    }
    public boolean addPacient(Pacients pacient)
    {
        return true;
    }
    public boolean deletePacient(String reservationID){
        return false;
    }
}

