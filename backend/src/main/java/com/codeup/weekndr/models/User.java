package com.codeup.weekndr.models;

import com.codeup.weekndr.models.Trip;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, unique = true)
    private String username;
    private String email;
    private String phone_number;
    @Column(length = 255)
    private String img_path;
    @Column(nullable = false)
    private String password;
    private LocalDateTime created_at;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="users_trips",
            joinColumns={@JoinColumn(name="trip_id")},
            inverseJoinColumns={@JoinColumn(name="user_id")}
    )
    private List<Trip> trips;

    public User(){}

    public User(User copy){
        id = copy.id;
        username = copy.username;
        email = copy.email;
        phone_number= copy.phone_number;
        img_path = copy.img_path;
        password = copy.password;
        created_at = copy.created_at;
        trips = copy.trips;
    }

    public User(String username, String email, String phone_number, String img_path, String password, List<Trip> trips, Timestamp created){
        this.username = username;
        this.email = email;
        this.phone_number= phone_number;
        this.img_path = img_path;
        this.password = password;
        this.created_at = created.toLocalDateTime();
        this.trips = trips;
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

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
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

