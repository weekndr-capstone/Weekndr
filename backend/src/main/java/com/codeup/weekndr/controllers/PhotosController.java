package com.codeup.weekndr.controllers;
import com.codeup.weekndr.models.Photo;
import com.codeup.weekndr.models.Place;
import com.codeup.weekndr.repositories.PhotoRepository;
import com.codeup.weekndr.repositories.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class PhotosController {

    @Autowired
    private PhotoRepository photoDao;

    @GetMapping("/photos")
    public Iterable<Photo> photoList(){
        return photoDao.findAll();
    }

    @GetMapping("/photo")
    public Photo onePhoto(@RequestParam(name="id") long id){
        return photoDao.findById(id);
    }

    @PostMapping("/placePhoto")
    public Photo savePhoto(@RequestBody Photo photo){
        photoDao.save(photo);
        return photoDao.findById(photo.getId());
    }

    @GetMapping("/placePhotos")
    public Iterable<Photo> placePhotos(@RequestParam (name="place") Place place) {
        return photoDao.findAllByPlaceId(place.getId());
    }

}
