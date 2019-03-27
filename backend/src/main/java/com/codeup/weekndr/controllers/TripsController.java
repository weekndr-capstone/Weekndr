package com.codeup.weekndr.controllers;

import com.codeup.weekndr.models.Trip;
import com.codeup.weekndr.models.User;
import com.codeup.weekndr.repositories.TripRepository;
import com.codeup.weekndr.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

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

    @GetMapping("/checkUserMain{trip}{user}")
    public boolean checkIfUserIsMain(@RequestParam long user, @RequestParam long trip){

        User Check = tripDao.findById(trip).getUser();
        return Check.getId() == user;
    }

    @PostMapping("/trip")
    public Trip userInputed(@RequestBody Trip trip){

        List<User> users = new ArrayList<>();
        users.add(userDao.findById(trip.getUser().getId()));
        if (trip.getUsers().toArray().length >= 1){
            for(User user : trip.getUsers()) {
                System.out.println(user.getPhoneNumber());
                users.add(userDao.findByPhoneNumber(user.getPhoneNumber().trim()));
            }
        }

        trip.setUsers(users);
        tripDao.save(trip);
        return trip;
    }

    @GetMapping("/testtrip{id}")
    public Trip gettrip(@RequestParam long id){
        return tripDao.findById(id);
    }
}
