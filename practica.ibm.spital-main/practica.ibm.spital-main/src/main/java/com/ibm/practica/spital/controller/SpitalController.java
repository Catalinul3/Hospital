package com.ibm.practica.spital.controller;

import com.ibm.practica.spital.DTOs.*;
import com.ibm.practica.spital.repository.ReservationRepo;
import com.ibm.practica.spital.service.SpitalService;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Log4j2
@RestController
@RequestMapping("/spital")
public class SpitalController {

    @Autowired
    private SpitalService service;


    @GetMapping("/getAllPacients")
    public List<Pacients> getAllPacients(){
        log.info("getAllPacients has started...");
        List<Pacients> result=service.getAllPacients();

        log.info("getAllPacients has finished...");
        return result;
    }

    @GetMapping("/allReservations")
    public List<ReservationDTO> getReservations(){
        return service.getAllReservations();
    }

    @GetMapping("/reservation")
    public ResponseEntity<ReservationDTO> getReservation(@RequestBody String resID)
    {
        ReservationDTO result=service.getReservation(resID);
        if(ObjectUtils.isEmpty(result))
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }
    @GetMapping("/getPacientReservation")
    public List<ReservationDTO> getReservationForPacient(String pacientID){

return service.getReservationForPacient(pacientID);
   }
    @PostMapping("/addReservation")
    public ResponseEntity addReservation(@RequestBody AddReservationDTO reservation){

        return service.addReservation(reservation) ? ResponseEntity.ok().build() : ResponseEntity.badRequest().build();
    }

    @PostMapping("/addPacient")
    public ResponseEntity<Object> addPacient(@RequestBody @Valid AddPacientDTO pacient){
        log.info("addPacient() started for : " + pacient);
        return service.addPacient(pacient) ? ResponseEntity.ok().build() : ResponseEntity.badRequest().build();
    }
    @PostMapping("/addSection")
    public ResponseEntity<Object> addSection(@RequestBody @Valid AddSectionDTO section){
        log.info("addSection() started for: "+section );
        return service.addSection(section)?ResponseEntity.ok().build():ResponseEntity.badRequest().body("Invalid section. Section cannot be null");
    }
    @DeleteMapping("/deleteReservation")
    public ResponseEntity deleteReservation(@RequestParam String reservationID){

        service.deleteReservation(reservationID);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/deletePacient{reservationID}")
    public ResponseEntity deletePacient(@RequestParam String pacientID){
        return service.deletePacient(pacientID) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @PutMapping("/editPacient")
    public ResponseEntity editPacient(@RequestBody Pacients pacientDTO){
        return service.editPacient(pacientDTO) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();

    }

    @PutMapping("/editReservation")
    public ReservationDTO editReservation(String id, String spec, LocalDateTime time){return service.editReservation(id,spec,time);}
    @GetMapping("/getAllSections")
    public List<SectionDTO> getAllSections(){return service.getAllSections();}
    @GetMapping("/getAllNumberOfAvailableDoctors")
    public int getNumberOfDoctors(){return 0;
    }

    @PutMapping("/editSection")
    public SectionDTO editSection(String id, String name, int doc, int pac){
        return service.editSection(id,name,doc,pac);
    }
    @DeleteMapping("/deleteSection")
    public ResponseEntity deleteSection(String id)
    {
        return service.deleteSection(id);
    }


}
