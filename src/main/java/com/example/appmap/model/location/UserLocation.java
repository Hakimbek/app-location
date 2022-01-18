package com.example.appmap.model.location;

import com.example.appmap.model.User;

import javax.persistence.*;

@Entity
public class UserLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(optional = false)
    private User user;

    @ManyToOne(optional = false)
    private Country country;

    @ManyToOne(optional = false)
    private Region region;

    @ManyToOne(optional = false)
    private City city;

    @ManyToOne(optional = false)
    private Address address;
}
