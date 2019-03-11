package com.codeup.weekndr.controllers;

import com.codeup.weekndr.models.User;
import com.codeup.weekndr.repositories.UserRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsersController {

    private UserRepository userDao;

    public UsersController(UserRepository userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/userlist.json")
    public Iterable<User> userList(){
        return userDao.findAll();
    }

    @PostMapping("/userPost")
    public Iterable<User> userInput( User user){
        userDao.save(user);
        return userDao.findAll();
    }
}