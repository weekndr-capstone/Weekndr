package com.codeup.weekndr.controllers;

import com.codeup.weekndr.models.Comment;
import com.codeup.weekndr.repositories.CommentRepository;
import com.codeup.weekndr.repositories.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CommentsController {

    @Autowired
    private CommentRepository commentDao;

    @Autowired
    private PlaceRepository placeDao;

    @GetMapping("/commentlist")
    public Iterable<Comment> commentList(){
        return commentDao.findAll();
    }

    @GetMapping("/comment")
    public Comment oneComment(@RequestParam long place_id){
        return commentDao.findById(place_id);
    }

    @PostMapping("/commentPost")
    public Iterable<Comment> userInput(@RequestBody Comment comment){
        System.out.println(comment.getComment() + " --COMMENT");
        System.out.println(comment.getCreated_at() + " --CREATED AT");
        System.out.println(comment.getParent_comment_id() + " --PARENT COMMENT ID");
        System.out.println(comment.getPlace_id().getId() + " --PLACE ID");

        commentDao.save(comment);
        return commentDao.findAll();
    }



}