package com.codeup.weekndr.models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "photos")
public class Photo {

    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false)
    private String img_path;
    private LocalDateTime created_at;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.MERGE)
    @JoinColumn(name = "place_id")
    private Place place;

    public Photo() {}

    public Photo(String img_path, LocalDateTime created_at, User user, Place place) {
        this.img_path = img_path;
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

    public String getImg_path() {
        return img_path;
    }

    public void setImg_path(String img_path) {
        this.img_path = img_path;
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

    public void setPlace(Place place) {
        this.place = place;
    }
}
