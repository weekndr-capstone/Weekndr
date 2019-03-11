package com.codeup.weekndr.controllers;


import com.codeup.weekndr.models.Trip;
import com.codeup.weekndr.models.Vote;
import com.codeup.weekndr.repositories.TripRepository;
import com.codeup.weekndr.repositories.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VotesController {

    @Autowired
    private VoteRepository voteDao;

    @GetMapping("/voteslist")
    public
    Iterable<Vote> tripList(){
        return voteDao.findAll();
    }

    @GetMapping("/vote/{id}")
    public Vote oneTrip(@PathVariable long id){
        return voteDao.findById(id);
    }

    @PostMapping("/vote")
    public void userInputed(Vote vote) {
        voteDao.save(vote);
    }
}