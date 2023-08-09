package com.bnta.airline.services;

import com.bnta.airline.models.Flight;
import com.bnta.airline.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FlightService {

    @Autowired
    FlightRepository flightRepository;

    public List<Flight> findAllFlightsInfo(){
        return flightRepository.findAll();
    }

    public Flight findFlightInfo(Long id){
        return flightRepository.findById(id).get();
    }

    public void saveFlight(Flight flight){
        flightRepository.save(flight);
    }

    public void cancelFlight(Long id){
        flightRepository.deleteById(id);
    }


}
