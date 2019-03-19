package com.codeup.weekndr.controllers;

import com.codeup.weekndr.models.Comment;
import com.codeup.weekndr.repositories.CommentRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class CommentsController {

    private CommentRepository commentDao;

    public CommentsController(CommentRepository commentDao) {
        this.commentDao = commentDao;
    }

    @GetMapping("/commentlist")
    public Iterable<Comment> commentList(){
        return commentDao.findAll();
    }

    @GetMapping("/comment")
    public Comment oneComment(@RequestParam long id){
        return commentDao.findById(id);
    }

    @PostMapping("/commentPost")
    public Iterable<Comment> userInput(@RequestBody Comment comment){
        commentDao.save(comment);
        return commentDao.findAll();
    }

    @GetMapping("/placeComments")
    public Iterable<Comment> placesComments(long place_id){
        return commentDao.findByPlaceId(place_id);
    }


}