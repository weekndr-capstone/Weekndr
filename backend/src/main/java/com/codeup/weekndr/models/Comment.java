package com.codeup.weekndr.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false,columnDefinition = "TEXT")
    private String comment;
    @Column(nullable = false)
    private LocalDateTime created_at;
    @OneToOne
    @Cascade(org.hibernate.annotations.CascadeType.MERGE)
    @JoinColumn(name = "user")
    private User user;
    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.MERGE)
    @JoinColumn(name = "place")
    @JsonBackReference
    private Place place;
    @OneToOne
    @JoinColumn(name ="parent_comment_id")
    private Comment parentComment;

    public Comment() {}

    public Comment(String comment, LocalDateTime created_at, User user, Place place, Comment parentComment) {
        this.comment = comment;
        this.created_at = created_at;
        this.user = user;
        this.place = place;
        this.parentComment = parentComment;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Place getPlace() { return place; }

    public void setPlace(Place place) { this.place = place; }

    public Comment getParentComment() {
        return parentComment;
    }

    public void setParentComment(Comment parent_comment) {
        this.parentComment = parent_comment;
    }
}
