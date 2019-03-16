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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
public class AuthenticationController {

    @Autowired
    private UserRepository userDao;
    private TripRepository tripDao;

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
    public User loginUser(@RequestBody User user) {
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getPhone_number());
        authenticate(user);
        User loggedIn = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (loggedIn.getUsername() != null){
            User finaluser = userDao.findByUsername(loggedIn.getUsername());
            for(Trip t : finaluser.getTrips())
            {
                System.out.println(t + "TRIPS");
            }
            return finaluser;
        }else   {
            return null;
        }
    }
}
