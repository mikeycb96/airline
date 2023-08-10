package com.bnta.airline.controllers;


import com.bnta.airline.models.Passenger;
import com.bnta.airline.models.PassengerDTO;
import com.bnta.airline.services.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("passengers")
public class PassengerController {

    @Autowired
    PassengerService passengerService;

    //    SHOW
    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Passenger>> getPassenger(@PathVariable Long id){
        Passenger targetPassenger = passengerService.displayPassengerInfo(id);
        return new ResponseEntity(targetPassenger, HttpStatus.OK);

    }

    //    INDEX
    @GetMapping
    public ResponseEntity<List<Passenger>> getAllPassengers(){
        return new ResponseEntity(passengerService.displayAllPassengersInfo(), HttpStatus.OK);
    }

    //    CREATE
    @PostMapping
    public ResponseEntity<List<Passenger>> postPassenger(@RequestBody Passenger passenger){
        passengerService.addPassenger(passenger);
        return new ResponseEntity<>(passengerService.displayAllPassengersInfo(), HttpStatus.CREATED);
    }

    //    UPDATE
    @PatchMapping
    public ResponseEntity<Passenger> updatePassengerFlights(@RequestBody PassengerDTO passengerDTO,
                                                            @PathVariable Long id){
        Passenger updatePassengerFlights = passengerService.bookPassenger(passengerDTO, id);
        return new ResponseEntity<>(updatePassengerFlights, HttpStatus.OK);
    }

    //    UPDATE
    @PutMapping(value = "/{id}")
    public ResponseEntity<Passenger> updatePassenger(@RequestBody PassengerDTO passengerDTO, @PathVariable Long id){
        Passenger updatedPassenger = passengerService.updatePassenger(passengerDTO, id);
        return new ResponseEntity<>(updatedPassenger, HttpStatus.OK);
    }

}
