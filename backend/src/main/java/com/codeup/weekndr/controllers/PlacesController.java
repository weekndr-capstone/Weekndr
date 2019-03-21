package com.codeup.weekndr.controllers;
import com.codeup.weekndr.models.Place;
import com.codeup.weekndr.models.Trip;
import com.codeup.weekndr.repositories.PlaceRepository;
import com.codeup.weekndr.repositories.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PlacesController {

    @Autowired
    private PlaceRepository placeDao;
    @Autowired
    private TripRepository tripDao;

    @GetMapping("/places")
    public Iterable<Place> placeList(){
        return placeDao.findAll();
    }

   @GetMapping("/place")
   public Place onePlace(@RequestParam(name="id") long id){
        return placeDao.findById(id);
   }

   @PostMapping("/place")
    public Place savePlace(@RequestBody Place place){
           placeDao.save(place);
           Trip trip = tripDao.findById(place.getTrip_id().getId());
           trip.getPlaces().add(place);

           return placeDao.findById(place.getId());
   }
//
   @PostMapping("/editPlace{id}{description}")
    public Place editPlace(@RequestParam long id, @RequestParam String description){

        Place exists = placeDao.findById(id);
        exists.setDescription(description);

        placeDao.save(exists);

        return exists;
    }



//    @PostMapping("/deleteItem")
//    public Place deletePlace(){
//
//    }
}
