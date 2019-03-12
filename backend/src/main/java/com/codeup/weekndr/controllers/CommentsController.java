package com.codeup.weekndr.controllers;

import com.codeup.weekndr.models.Comment;
import com.codeup.weekndr.repositories.CommentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public Iterable<Comment> userInput(Comment comment){
        commentDao.save(comment);
        return commentDao.findAll();
    }
}