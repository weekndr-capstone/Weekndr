package com.codeup.weekndr.controllers;

import com.codeup.weekndr.models.User;
import com.codeup.weekndr.repositories.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {

    private UserRepository userDao;

    public UsersController(UserRepository userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/userlist")
    public Iterable<User> userList(){
        return userDao.findAll();
    }

    @GetMapping("/userlist")
    public User oneUser(@RequestParam long id){
        return userDao.findById(id);
    }

    @PostMapping("/userPost")
    public Iterable<User> userInput(User user){
        userDao.save(user);
        return userDao.findAll();
    }
}