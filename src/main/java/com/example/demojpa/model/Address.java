package com.example.demojpa.model;

import javax.persistence.*;

@Entity
@Table(name = "ADDRESS")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "COUNTRY", nullable = false)
    private String country;

    @Column(name = "REGION", nullable = false)
    private String region;

    @Column(name = "CITY", nullable = false)
    private String city;

    @Column(name = "STREET", nullable = false)
    private String street;

    @Column(name = "HOUSE", nullable = false)
    private String house;

    @Column(name = "FLAT", nullable = false)
    private String flat;

    public Address() {
    }

    public Address(String country, String region, String city, String street, String house, String flat) {
        this.country = country;
        this.region = region;
        this.city = city;
        this.street = street;
        this.house = house;
        this.flat = flat;
    }

    public Long getId() {
        return id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getFlat() {
        return flat;
    }

    public void setFlat(String flat) {
        this.flat = flat;
    }

    @Override
    public String toString() {
        return "Address: {id=" + getId() + ", " +
                "country=" + getCountry() + ", " +
                "region=" + getRegion() + ", " +
                "city=" + getCity() + ", " +
                "street=" + getStreet() + ", " +
                "house=" + getHouse() + ", " +
                "flat=" + getFlat() + "}";
    }
}
