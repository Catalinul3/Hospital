package com.ibm.practica.spital.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequestMapping("/spital")
public class SpitalController {

    @GetMapping("/all")
    public String getAllPacients(){
        log.info("getAllPacients has started...");
        return "Test";
    }

    @GetMapping("/reservations")
    public String getReservations(){
        return "Reservations";
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
