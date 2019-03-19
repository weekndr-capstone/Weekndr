package com.codeup.weekndr.models;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "places")
public class Place {

    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false)
    private String yelp_uniq;
    private String name;
    private String address;
    private Boolean suggested;
    @Column
    private String image_url;
    private String websiteURL;
    private String hotelURL;
    private String phone_number;
    private String rating;
    private String price;
    private String description;
    private Date checkin_date;
    private Date checkout_date;
    private Date event_date;
    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime created_at;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user_id;
    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.MERGE)
    @JoinColumn(name = "trip_id")
    private Trip trip;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "place")
    private List<Vote> votes;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "place")
    private List<Photo> photos;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "place")
    private List<Comment> comments;

    public Place(){}

    public Place(String yelp_uniq, String name, String address, Boolean suggested, String image_url, String websiteURL, String hotelURL, String phone_number, String rating, String price,
                 Date checkin_date, Date checkout_date, User user_id, Trip trip_id,
                 List<Vote> votes, List<Comment> comments, List<Photo> photos) {
        this.yelp_uniq = yelp_uniq;
        this.name = name;
        this.address = address;
        this.suggested = suggested;
        this.image_url = image_url;
        this.websiteURL = websiteURL;
        this.hotelURL = hotelURL;
        this.phone_number = phone_number;
        this.rating = rating;
        this.price = price;
        this.checkin_date = checkin_date;
        this.checkout_date = checkout_date;
        this.votes = votes;
        this.comments = comments;
        this.photos = photos;
        this.user_id = user_id;
        this.trip = trip_id;
    }

    public Place(String name, String address, String image_url, Date event_date, String phone_number, String yelp_uniq, String websiteURL, String price, String rating, Boolean suggested,
                 String description, User user_id, Trip trip_id){
        this.name = name;
        this.address = address;
        this.image_url = image_url;
        this.event_date = event_date;
        this.yelp_uniq = yelp_uniq;
        this.websiteURL = websiteURL;
        this.phone_number = phone_number;
        this.price = price;
        this.rating = rating;
        this.description = description;
        this.suggested = suggested;
        this.user_id = user_id;
        this.trip = trip_id;
    }

    public Place(String yelp_uniq, String name, String address, Boolean suggested, String image_url, String websiteURL, String phone_number, String rating, String price, Date event_date, User user_id, Trip trip_id) {
        this.yelp_uniq = yelp_uniq;
        this.name = name;
        this.address = address;
        this.suggested = suggested;
        this.image_url = image_url;
        this.websiteURL = websiteURL;
        this.phone_number = phone_number;
        this.rating = rating;
        this.price = price;
        this.event_date = event_date;
        this.user_id = user_id;
        this.trip = trip_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getYelp_uniq() {
        return yelp_uniq;
    }

    public void setYelp_uniq(String yelp_uniq) {
        this.yelp_uniq = yelp_uniq;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getSuggested() {
        return suggested;
    }

    public void setSuggested(Boolean suggested) {
        this.suggested = suggested;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getWebsiteURL() {
        return websiteURL;
    }

    public void setWebsiteURL(String websiteURL) {
        this.websiteURL = websiteURL;
    }

    public String getHotelURL() {
        return hotelURL;
    }

    public void setHotelURL(String hotelURL) {
        this.hotelURL = hotelURL;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Date getCheckin_date() {
        return checkin_date;
    }

    public void setCheckin_date(Date checkin_date) {
        this.checkin_date = checkin_date;
    }

    public Date getCheckout_date() {
        return checkout_date;
    }

    public void setCheckout_date(Date checkout_date) {
        this.checkout_date = checkout_date;
    }

    public Date getEvent_date() {
        return event_date;
    }

    public void setEvent_date(Date event_date) {
        this.event_date = event_date;
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

    public Trip getTrip_id() {
        return trip;
    }

    public void setTrip_id(Trip trip_id) {
        this.trip = trip_id;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
