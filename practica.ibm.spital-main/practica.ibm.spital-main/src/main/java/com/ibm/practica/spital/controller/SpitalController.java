package com.ibm.practica.spital.controller;

import com.ibm.practica.spital.DTOs.AddReservation;
import com.ibm.practica.spital.DTOs.Pacients;
import com.ibm.practica.spital.DTOs.Reservation;
import com.ibm.practica.spital.service.SpitalService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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
    public List<Reservation> getReservations(){
        return service.getAllReservations();
    }

    @GetMapping("/reservation")
    public Reservation getReservationForPacient(int id){
        return service.getReservation();
    }
    @GetMapping("/getPacientReservation")
    public ResponseEntity<List<Reservation>> getReservationForPacient(String pacientID){

        if(service.getReservationForPacient(pacientID).isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        return ResponseEntity.of(Optional.ofNullable(service.getReservationForPacient(pacientID)));
    }
    @PostMapping("/addReservation")
    public ResponseEntity addReservation(AddReservation reservation){

        return service.addReservation(reservation) ? ResponseEntity.ok().build() : ResponseEntity.badRequest().build();
    }

    @PostMapping("/addPacient")
    public String addPacient(){
        return "Pacient added";
    }

    @DeleteMapping("/deleteReservation")
    public ResponseEntity deleteReservation(String reservationID){

        if(service.deleteReservation(reservationID)){
            ResponseEntity.ok().build();
        } else ResponseEntity.notFound().build();

        return service.deleteReservation(reservationID) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/deletePacient")
    public String deletePacient(){
        return "Pacient deleted";
    }

    @PutMapping("/editPacient")
    public String editPacient(){
        return "Pacient edited";
    }

    @PutMapping("/editReservation")
    public Reservation editReservation(String id, String spec, LocalDateTime time){return service.editReservation(id,spec,time);}


}
