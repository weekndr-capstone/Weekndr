package com.codeup.weekndr.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
@JsonIdentityInfo(scope=User.class, generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
public class User {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false, unique = true)
    private String phoneNumber;
    @Column(length = 255)
    private String img_path;
    @Column(nullable = false)
    private String password;
    private LocalDateTime created_at;
    @ManyToMany(mappedBy = "users")
    private List<Trip> trips;

    public User(){}

    public User(User copy){
        id = copy.id;
        username = copy.username;
        email = copy.email;
        phoneNumber= copy.phoneNumber;
        img_path = copy.img_path;
        password = copy.password;
        created_at = copy.created_at;
        trips = copy.trips;
    }

    public User(String username, String email, String phoneNumber, String img_path, String password, List<Trip> trips, Timestamp created){
        this.username = username;
        this.email = email;
        this.phoneNumber= phoneNumber;
        this.img_path = img_path;
        this.password = password;
        this.created_at = created.toLocalDateTime();
        this.trips = trips;
    }

    public User(String username, String password){
        this.username =username;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getImg_path() {
        return img_path;
    }

    public void setImg_path(String img_path) {
        this.img_path = img_path;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at.toLocalDateTime();
    }

    public List<Trip> getTrips() {
        return trips;
    }

    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }
}

