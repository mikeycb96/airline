package com.bnta.airline.services;

import com.bnta.airline.models.Flight;
import com.bnta.airline.models.Passenger;
import com.bnta.airline.models.PassengerDTO;
import com.bnta.airline.repositories.FlightRepository;
import com.bnta.airline.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService {

    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    FlightRepository flightRepository;

    public Passenger bookPassenger(PassengerDTO passengerDTO, Long id){
        Passenger passenger = new Passenger(passengerDTO.getName(), passengerDTO.getEmailAddress());

        for (Long flightId : passengerDTO.getFlightIds()){
            Flight flight = flightRepository.findById(flightId).get();
            passenger.addFlight(flight);
        }
        return passengerRepository.save(passenger);
    }

    public Passenger displayPassengerInfo(Long id){
        return passengerRepository.findById(id).get();
    }

    public List<Passenger> displayAllPassengersInfo() {
        return passengerRepository.findAll();
    }


    public void addPassenger(Passenger passenger) {
        passengerRepository.save(passenger);
    }

    public Passenger updatePassenger(PassengerDTO passengerDTO, Long id) {
        Passenger passengerToUpdate = passengerRepository.findById(id).get();
        passengerToUpdate.setName(passengerDTO.getName());
        passengerToUpdate.setEmailAddress(passengerDTO.getEmailAddress());
        for (Long flightId : passengerDTO.getFlightIds()) {
            Flight flight = flightRepository.findById(flightId).get();
            passengerToUpdate.addFlight(flight);
        }
        passengerRepository.save(passengerToUpdate);
        return passengerToUpdate;
    }
}
