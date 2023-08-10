package com.bnta.airline.components;

import com.bnta.airline.models.Flight;
import com.bnta.airline.models.Passenger;
import com.bnta.airline.repositories.FlightRepository;
import com.bnta.airline.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    FlightRepository flightRepository;

    public DataLoader(){

    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Flight flight1 = new Flight("Tokyo", 250,
                "12/08/23", "0900");
        flightRepository.save(flight1);
        Flight flight2 = new Flight("Singapore", 300,
                "25/08/23", "0845");
        flightRepository.save(flight2);
        Flight flight3 = new Flight("Paris", 150,
                "15/09/23", "1645");
        flightRepository.save(flight3);
        Flight flight4 = new Flight("Hong Kong", 325,
                "26/09/23", "1030");
        flightRepository.save(flight4);
        Flight flight5 = new Flight("Seoul", 280,
                "22/10/23", "1245");
        flightRepository.save(flight5);
        Flight flight6 = new Flight("Sydney", 300,
                "07/12/23", "1900");
        flightRepository.save(flight6);



        Passenger passenger1 = new Passenger("Mikey", "mikey@bnta.com");
        passenger1.addFlight(flight1);
        passenger1.addFlight(flight3);
        passengerRepository.save(passenger1);

        Passenger passenger2 = new Passenger("Kevin", "kevin@bnta.com");
        passenger1.addFlight(flight1);
        passenger1.addFlight(flight5);
        passengerRepository.save(passenger2);

        Passenger passenger3 = new Passenger("Callum", "callum@bnta.com");
        passenger1.addFlight(flight4);
        passenger1.addFlight(flight5);
        passengerRepository.save(passenger3);

        Passenger passenger4 = new Passenger("Rohaib", "rohaib@bnta.com");
        passenger1.addFlight(flight3);
        passenger1.addFlight(flight4);
        passengerRepository.save(passenger4);

        Passenger passenger5 = new Passenger("Tarek", "tarek@bnta.com");
        passenger1.addFlight(flight2);
        passenger1.addFlight(flight3);
        passengerRepository.save(passenger5);

        Passenger passenger6 = new Passenger("Mohamed", "mohamed@bnta.com");
        passenger1.addFlight(flight3);
        passenger1.addFlight(flight5);
        passengerRepository.save(passenger6);

        Passenger passenger7 = new Passenger("Zaiyad", "zaiyad@bnta.com");
        passenger1.addFlight(flight1);
        passenger1.addFlight(flight4);
        passengerRepository.save(passenger7);

        Passenger passenger8 = new Passenger("Abdulaziz", "abdulaziz@bnta.com");
        passenger1.addFlight(flight4);
        passenger1.addFlight(flight5);
        passengerRepository.save(passenger8);

    }
}

