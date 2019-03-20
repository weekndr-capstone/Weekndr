package com.codeup.weekndr.controllers;


import com.codeup.weekndr.models.Trip;
import com.codeup.weekndr.models.User;
import com.codeup.weekndr.repositories.TripRepository;
import com.codeup.weekndr.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TripsController {

    @Autowired
    private TripRepository tripDao;
    @Autowired
    private UserRepository userDao;

    @GetMapping("/triplist")
    public Iterable<Trip> tripList(){
        return tripDao.findAll();
    }

    @GetMapping("/trip/{id}")
    public Trip oneTrip(@PathVariable long id){
        return tripDao.findById(id);
    }

    @PostMapping("/trip")
    public Trip userInputed(@RequestBody Trip trip){
        tripDao.save(trip);
        System.out.println(trip.getUser().getId() + "USER ID");
        User user = userDao.findById(trip.getUser().getId());
        user.getTrips().add(trip);
        userDao.save(user);
        return trip;
    }
}
