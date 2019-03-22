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

    @PostMapping("/trip")
    public Trip userInputed(@RequestBody Trip trip){
//        System.out.println(trip.getUsers());
//
//        if (trip.getUsers().toArray().length >= 1){
//            for(User user : trip.getUsers()) {
//                System.out.println(user.getPhoneNumber());
//                User follower = userDao.findByPhoneNumber(user.getPhoneNumber());
//                System.out.println(follower.getTrips());
//                follower.getTrips().add(trip);
//                userDao.save(follower);
//            }
//        }
//        System.out.println(trip.getUser().getId() + "USER ID");
//        User main = userDao.findById(trip.getUser().getId());
//        main.getTrips().add(trip);
//        userDao.save(main);
        List<User> users = new ArrayList<>();
        users.add(userDao.findById(trip.getUser().getId()));
        if (trip.getUsers().toArray().length >= 1){
            for(User user : trip.getUsers()) {
                System.out.println(user.getPhoneNumber());
                users.add(userDao.findByPhoneNumber(user.getPhoneNumber().trim()));
            }
        }

        for (User usertest : users){
            System.out.println(usertest.getPhoneNumber());
        }

        trip.setUsers(users);
        tripDao.save(trip);
        return trip;
    }
}
