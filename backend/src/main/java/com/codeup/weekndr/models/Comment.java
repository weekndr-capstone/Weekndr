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
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;
    @OneToOne
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JoinColumn(name = "places_id")
    private Place places;
    @OneToOne
    @JoinColumn(name ="comment_id")
    private Comment parent_comment_id;
    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JoinColumn(name = "trip_id")
    private Place place;

    public Comment() {}

    public Comment(String comment, LocalDateTime created_at, User user, Place places, Comment parent_comment_id) {
        this.comment = comment;
        this.created_at = created_at;
        this.user = user;
        this.places = places;
        this.parent_comment_id = parent_comment_id;
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

    public Place getPlaces() {
        return places;
    }

    public void setPlaces(Place places) {
        this.places = places;
    }

    public Comment getParent_comment_id() {
        return parent_comment_id;
    }

    public void setParent_comment_id(Comment parent_comment_id) {
        this.parent_comment_id = parent_comment_id;
    }
}
