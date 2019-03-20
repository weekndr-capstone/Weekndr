package com.codeup.weekndr.controllers;


import com.codeup.weekndr.models.Place;
import com.codeup.weekndr.models.User;
import com.codeup.weekndr.models.Vote;
import com.codeup.weekndr.repositories.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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


//    @GetMapping("/itenerary")
//    public int getVoteCount(@RequestBody Trip trip){
//        Place place = vote.getPlace();
//        List<Vote> voteList =  voteDao.findVotesByPlaceId(place);
//        int voteCount = 0;
//
//            for(Vote singleVote: voteList){
//                voteCount++;
//            }
//
//            return voteCount;
//    }


    @PostMapping("/vote")
    public boolean userVote(@RequestBody Vote vote) {
        User user = vote.getUser();
        Place place = vote.getPlace();
        System.out.println(user);
        System.out.println(place);
    //find the vote by place id so that you can get the number of upvotes to dispaly:
        List<Vote> voteList =  voteDao.findVotesByPlaceId(place);
        int voteCount = 0;

        for(Vote singleVote: voteList){
            voteCount++;
        }


        Vote voteFromDb = voteDao.findByUserAndPlace(user, place);

        if (voteFromDb != null) {
            boolean upVoteStatusFromDb = voteFromDb.getUpvote();
            if (!upVoteStatusFromDb) {
                voteFromDb.setUpvote(true);
                voteDao.save(voteFromDb);
                return voteFromDb.getUpvote();
            } else if (upVoteStatusFromDb) {
                voteFromDb.setUpvote(false);
                voteDao.save(voteFromDb);
                return voteFromDb.getUpvote();
            }
        } else {
            voteDao.save(vote);
            return vote.getUpvote();
        }
        return false;
    }
}