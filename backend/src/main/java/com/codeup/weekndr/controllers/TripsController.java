package com.codeup.weekndr.controllers;


import com.codeup.weekndr.models.Trip;
import com.codeup.weekndr.repositories.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class TripsController {

    @Autowired
    private TripRepository tripDao;

    @GetMapping("/triplist")
    public
    Iterable<Trip> tripList(){
        return tripDao.findAll();
    }

    @GetMapping("/trip/{id}")
    public Trip oneTrip(@PathVariable long id){
        return tripDao.findById(id);
    }

    @PostMapping("/trip")
    public void userInputed(Trip trip){
        tripDao.save(trip);
    }
}
