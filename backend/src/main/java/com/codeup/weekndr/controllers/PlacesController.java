package com.codeup.weekndr.controllers;
import com.codeup.weekndr.models.Place;
import com.codeup.weekndr.repositories.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@RestController
public class PlacesController {

    @Autowired
    private PlaceRepository placeDao;

    @GetMapping("/places")
    public Iterable<Place> placeList(){
        return placeDao.findAll();
    }

   @GetMapping("/place")
   public Place onePlace(@RequestParam(name="id") long id){
        return placeDao.findById(id);
   }

   @PostMapping("/place")
    public void savePlace(Place place){
        placeDao.save(place);
   }
}