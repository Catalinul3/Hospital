package com.ibm.practica.spital.controller;

import com.ibm.practica.spital.DTOs.Pacients;
import com.ibm.practica.spital.DTOs.Reservation;
import com.ibm.practica.spital.service.SpitalService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public List<Reservation> getReservations(){
        return service.getAllReservations();
    }

    @GetMapping("/reservation")
    public String getReservationForPacient(int id){
        return "Reservation for Customer";
    }

    @PostMapping("/addReservation")
    public String addReservation(){
        return "Reservation added";
    }

    @PostMapping("/addPacient")
    public String addPacient(){
        return "Pacient added";
    }

    @DeleteMapping("/deleteReservation")
    public String deleteReservation(){
        return "Reservation deleted";
    }

    @DeleteMapping("/deletePacient")
    public String deletePacient(){
        return "Pacient deleted";
    }

    @PutMapping("/editPacient")
    public String editPacient(){
        return "Pacient edited";
    }
}
