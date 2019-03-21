package com.codeup.weekndr.controllers;

import com.codeup.weekndr.models.Comment;
import com.codeup.weekndr.models.Place;
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
        System.out.println(comment.getParentComment().getId() + " --PARENT COMMENT ID");
        if (comment.getParentComment().getId() == 0){
            comment.setParentComment(null);
        }
        System.out.println(comment.getPlace().getId() + " --PLACE ID");
        commentDao.save(comment);
        return commentDao.findByPlaceAndParentCommentIsNull(comment.getPlace());
    }

    @GetMapping("/placeComments")
    public Iterable<Comment> placeComments(@RequestParam Place place){
        return commentDao.findByPlaceAndParentCommentIsNull(place);
    }

    @GetMapping("/childComment")
    public Iterable<Comment> childComment(@RequestParam Comment comment){
        return commentDao.findByParentComment(comment);
    }
}