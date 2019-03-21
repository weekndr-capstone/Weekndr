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
    @Cascade(org.hibernate.annotations.CascadeType.MERGE)
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.MERGE)
    @JoinColumn(name = "place_id")
    private Place place;

    public Vote() {}

    public Vote(LocalDateTime created_at, User user, Place place, Boolean upvote) {
        this.created_at = created_at;
        this.user = user;
        this.place = place;
        this.upvote = upvote;
    }

    public Vote(LocalDateTime created_at, User user, Place place) {
        this.created_at = created_at;
        this.user = user;
        this.place = place;
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

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place places) {
        this.place = places;
    }
}
