package com.codeup.weekndr.controllers;

import com.codeup.weekndr.models.User;
import com.codeup.weekndr.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsersController {

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
    public Iterable<User> userInput(@RequestBody User user){
        System.out.println(user);
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        userDao.save(user);
        return userDao.findAll();
    }
}