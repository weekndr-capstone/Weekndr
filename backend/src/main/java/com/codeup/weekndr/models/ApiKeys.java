package com.codeup.weekndr.models;

public class ApiKeys {
    private String yelp;
    private String weather;
    private String twillio;

    public ApiKeys(String weather, String twillio) {
        this.yelp = "mxTdeKLYylDLLC26lxF50VWBORZ0sOePtNx356IxfUbMBrn3QLYg63Gdukd051KXEK1-4Q7fBV5m0tyr1FBvJvck9CTL7a87m9zVrkhy6sD0VAzfzDX6Ji4sm96GXHYx";
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