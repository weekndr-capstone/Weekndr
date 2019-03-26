package com.codeup.weekndr.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "trips")
public class Trip {

    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false,columnDefinition = "TEXT")
    private String trip_description;
    @Column(nullable = false)
    private String title;
    private String location;
    private Date start_date;
    private Date end_date;
    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime created_at;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "trip")
    private List<Place> places;

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(
//            name="trips_users",
//            joinColumns={@JoinColumn(name="trip_id")},
//            inverseJoinColumns={@JoinColumn(name="user_id")}
//    )
    @ManyToMany(mappedBy = "trips")
    private List<User> users;

    public Trip() {}

    public Trip(String title, String location, String trip_description, Date start_date, Date end_date, User user, List<Place> places, List<User> users) {
        this.title = title;
        this.location = location;
        this.trip_description = trip_description;
        this.start_date = start_date;
        this.end_date = end_date;
        this.user = user;
        this.users = users;
        this.places = places;
    }
    public Trip(String title, String location, String trip_description, Date start_date, Date end_date, User user) {
        this.title = title;
        this.location = location;
        this.trip_description = trip_description;
        this.start_date = start_date;
        this.end_date = end_date;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public String getTrip_description() {
        return trip_description;
    }

    public void setTrip_description(String trip_description) {
        this.trip_description = trip_description;
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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }
}
