package com.codeup.weekndr.models;

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
    @JoinColumn(name = "user_id")
    private User user_id;
    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.MERGE)
    @JoinColumn(name = "place_id")
    private Place place_id;
    @OneToOne
    @JoinColumn(name ="parent_comment_id")
    private Comment comment_id;

    public Comment() {}

    public Comment(String comment, LocalDateTime created_at, User user_id, Place place_id, Comment comment_id) {
        this.comment = comment;
        this.created_at = created_at;
        this.user_id = user_id;
        this.place_id = place_id;
        this.comment_id = comment_id;
    }

    public Comment(String comment, LocalDateTime created_at, User user_id, Place place_id) {
        this.comment = comment;
        this.created_at = created_at;
        this.user_id = user_id;
        this.place_id = place_id;
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
        return user_id;
    }

    public void setUser(User user) {
        this.user_id = user;
    }

    public Comment getParent_comment_id() {
        return comment_id;
    }

    public void setParent_comment_id(Comment parent_comment_id) {
        this.comment_id = parent_comment_id;
    }

    public User getUser_id() { return user_id; }

    public void setUser_id(User user_id) { this.user_id = user_id; }

    public Place getPlace_id() { return place_id; }

    public void setPlace_id(Place place_id) { this.place_id = place_id; }
}
