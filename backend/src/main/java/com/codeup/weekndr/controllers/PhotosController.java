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
    public void savePhoto(@RequestBody Photo photo){
        System.out.println(photo.getImg_path());
        System.out.println(photo.getCreated_at());
        System.out.println(photo.getId());
        System.out.println(photo.getUser());
        System.out.println(photo.getPlace());
        photoDao.save(photo);
    }
//
//    @PostMapping("/profilePicture")
//    public void saveProfilePhoto(@RequestBody Photo photo){
//        photoDao.save(photo);
//    }

}
