package com.bnta.airline.services;

import com.bnta.airline.models.Flight;
import com.bnta.airline.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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

    public Flight updateFlight(Flight flight, Long id){
        Flight flightToUpdate = flightRepository.findById(id).get();
        flightToUpdate.setDestination(flight.getDestination());
        flightToUpdate.setCapacity(flight.getCapacity());
        flightToUpdate.setPassengers(flight.getPassengers());
        flightToUpdate.setDepartureDate(flight.getDepartureDate());
        flightToUpdate.setDepartureTime(flight.getDepartureTime());
        flightRepository.save(flightToUpdate);
        return flightToUpdate;
    }


}
