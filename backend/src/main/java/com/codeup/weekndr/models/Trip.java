package com.codeup.weekndr.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.sql.Timestamp;
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
    private LocalDateTime created_at;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user_id;

    @ManyToMany(mappedBy = "trips")
    @JsonBackReference
    private List<User> users;

    public Trip() {}

    public Trip(String title, String location, String trip_description, Date start_date, Date end_date, Timestamp created_at, User user_id, List<User> users) {
        this.title = title;
        this.location = location;
        this.trip_description = trip_description;
        this.start_date = start_date;
        this.end_date = end_date;
        this.created_at = created_at.toLocalDateTime();
        this.user_id = user_id;
        this.users = users;
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

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
