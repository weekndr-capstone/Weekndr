package com.codeup.weekndr.controllers;

import com.codeup.weekndr.models.Trip;
import com.codeup.weekndr.models.User;
import com.codeup.weekndr.models.UserWithRoles;
import com.codeup.weekndr.repositories.TripRepository;
import com.codeup.weekndr.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;

@RestController
public class AuthenticationController {

    @Autowired
    private UserRepository userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void authenticate(User user) {
        // Notice how we're using an empty list for the roles
        UserDetails userDetails = new UserWithRoles(user);
        Authentication auth = new UsernamePasswordAuthenticationToken(
                userDetails,
                userDetails.getPassword(),
                userDetails.getAuthorities()
        );
        SecurityContext context = SecurityContextHolder.getContext();
        context.setAuthentication(auth);
    }

    @PostMapping("/async-login")
    @ResponseBody
    public User doLogin(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password){
        User dbUser = userDao.findByUsername(username);
        if(dbUser != null && passwordEncoder.matches(password, dbUser.getPassword())) {
            System.out.println("Here");
            authenticate(dbUser);
        }else{
            System.out.println("Blere");
            dbUser = null;
        }
        return dbUser;
    }

    @GetMapping("/test.json")
    @ResponseBody
    public User PrintUser(){
        return userDao.findById(2);
    }
}
