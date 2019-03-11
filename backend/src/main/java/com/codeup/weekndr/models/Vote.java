package com.codeup.weekndr.models;


import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "votes")
public class Vote {

    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false)
    private Boolean upvote;
    private LocalDateTime created_at;
    @OneToOne
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;
    @OneToOne
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JoinColumn(name = "places_id")
    private Place places;

    public Vote() {}

    public Vote(Boolean upvote, LocalDateTime created_at, User user, Place places) {
        this.upvote = upvote;
        this.created_at = created_at;
        this.user = user;
        this.places = places;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Boolean getUpvote() {
        return upvote;
    }

    public void setUpvote(Boolean upvote) {
        this.upvote = upvote;
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
}
