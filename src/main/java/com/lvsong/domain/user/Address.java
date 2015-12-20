package com.lvsong.domain.user;

/**
 * Created by lvsong on 12/20/15.
 */
public class Address {
    private String street;
    private String country;
    private House house;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }
}
