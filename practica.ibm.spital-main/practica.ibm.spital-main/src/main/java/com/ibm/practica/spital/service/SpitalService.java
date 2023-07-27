package com.ibm.practica.spital.service;

import com.ibm.practica.spital.DTOs.*;
import com.ibm.practica.spital.entities.Pacient;
import com.ibm.practica.spital.entities.Reservation;
import com.ibm.practica.spital.entities.Section;
import com.ibm.practica.spital.repository.PacientRepo;
import com.ibm.practica.spital.repository.ReservationRepo;
import com.ibm.practica.spital.repository.SectionRepo;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
@Log4j2
public class SpitalService {
    private List<SectionDTO>sections;
    @Autowired
    PacientRepo pacientRepo;
    @Autowired
    SectionRepo sectionRepo;
    @Autowired
    ReservationRepo reservationRepo;

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
    public List<SectionDTO> getAllSections()
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

        return sectionRepo.findAll().stream().map(section -> mapper.map(section,SectionDTO.class))
                .collect(Collectors.toList());
    }

    public List<ReservationDTO>getAllReservations()
    {
        log.info("Service called getAllPacients");

        return reservationRepo.findAll().stream()
                .map(reservation -> mapper.map(reservation,ReservationDTO.class)).collect(Collectors.toList());
    }
    public ReservationDTO getReservation(String reservationID)
    {
        log.info("SpitalService.getReservation() retrieving all reservations...");

        return reservationRepo.findById(reservationID)
                .map(reservation -> mapper.map(reservation,ReservationDTO.class)).orElse(null);
    }
    public List<ReservationDTO>getReservationForPacient(String pacientID)
    {
        return reservationRepo.findAll().stream()
                .filter(r->r.getPacientID().equals(pacientID))
                .map(reservation ->mapper.map(reservation,ReservationDTO.class))
                .collect(Collectors.toList());
    }


    public boolean addReservation(AddReservationDTO reservationDTO){
        Reservation reservation=mapper.map(reservationDTO,Reservation.class);
        String id=UUID.randomUUID().toString();
        reservation.setId(id.replace("-",""));
        reservation.setTime(LocalDateTime.now());
        Reservation fromDb=reservationRepo.save(reservation);
        log.info("addReservation() Reservation saved with ID:" + fromDb.getId());
        return ObjectUtils.isNotEmpty(fromDb) ;

    }

    public void deleteReservation(String reservationID){
        log.info("deleteReservation() started.");
        reservationRepo.deleteById(reservationID);
        log.info("deleteReservation() finished.");
    }
    public ReservationDTO editReservation(String id, String spec, LocalDateTime time)
    {  List<ReservationDTO>list=getAllReservations();
        ReservationDTO newReservationDTO =new ReservationDTO();
       /* for(Reservation reservation:list)
        {
            if(reservation.getId().equals(id))
            {reservation.setReservationDate(time);
              reservation.setSpecialization(spec);
              newReservation=reservation;
            }
        }
        Old Style*/
        newReservationDTO =list.stream().filter(reservationDTO -> id.equals(reservationDTO.getId()))
                .findAny().orElse(null);
        if(newReservationDTO !=null)
        {
            newReservationDTO.setReservationDate(time);
            newReservationDTO.setSpecialization(spec);
        }
        return newReservationDTO;
    }

    public boolean addSection(AddSectionDTO sectionDTO)
    {
        Section section=mapper.map(sectionDTO,Section.class);
        String id=UUID.randomUUID().toString();
        section.setId(id.replace("-",""));
        Section s=sectionRepo.save(section);
        return ObjectUtils.isNotEmpty(s);

    }
    public SectionDTO editSection(String id,String name,int doctors, int pacients)
    {sections=getAllSections();
        SectionDTO newSection= new SectionDTO();
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
        SectionDTO sectionToDelete=new SectionDTO();
        sectionToDelete=sections.stream().filter(section -> id.equals(section.getId()))
                .findAny().orElse(null);
        if(sectionToDelete!=null)
        {
            sections.remove(sectionToDelete);
            return ResponseEntity.ok("Delete section"+sectionToDelete.getSpecializationName());

        }
        return ResponseEntity.badRequest().body(" Invalid section data. Section cannot be null.");
    }
    public boolean addPacient(AddPacientDTO pacient)
    {
        Pacient pt = mapper.map(pacient,Pacient.class);
        String id = UUID.randomUUID().toString();
        log.info("id is: " + id);
        pacient.setPacientID(id.replace("-",""));
        Pacient p = pacientRepo.save(pt);
        log.info("saved pacient id is: " + p.getPacientID());
        return ObjectUtils.isNotEmpty(p);
    }
    public boolean deletePacient(String pacientID){
        int deletedRows = pacientRepo.deletePacient(pacientID);
        log.info("deletePacient() deleted: " + deletedRows + " row(s)");
        return deletedRows > 0;
    }
    public boolean editPacient(Pacients pacientDto)
    {
        return true;
    }

}

