package com.codeup.weekndr.models;

public class ApiKeys {
    private String yelp;
    private String weather;
    private String twillio;

    public ApiKeys(String weather, String twillio) {
        this.weather = weather;
        this.twillio = twillio;
    }

    public String getYelp() {
        return yelp;
    }

    public void setYelp(String yelp) {
        this.yelp = yelp;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getTwillio() {
        return twillio;
    }

    public void setTwillio(String twillio) {
        this.twillio = twillio;
    }
}
