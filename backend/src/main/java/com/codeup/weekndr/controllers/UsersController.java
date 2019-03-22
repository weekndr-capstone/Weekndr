package com.codeup.weekndr.controllers;

import com.codeup.weekndr.models.Photo;
import com.codeup.weekndr.models.User;
import com.codeup.weekndr.repositories.PhotoRepository;
import com.codeup.weekndr.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsersController {

    @Autowired
    private PhotoRepository photoDao;

    @Autowired
    private UserRepository userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/userlist")
    public Iterable<User> userList(){
        return userDao.findAll();
    }

    @GetMapping("/user")
    public User oneUser(@RequestParam long id){
        return userDao.findById(id);
    }

    @PostMapping("/signup")
    public User userInput(@RequestBody User user){
        System.out.println(user);
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        userDao.save(user);
        return userDao.findById(user.getId());
    }

    @PostMapping("/profilePicture")
    public void savePhoto(@RequestBody Photo photo){
        System.out.println(photo.getImg_path());
        System.out.println(photo.getCreated_at());
        System.out.println(photo.getUser());
        System.out.println(photo.getPlace());
        photoDao.save(photo);
    }

}