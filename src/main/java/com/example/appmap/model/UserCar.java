package com.example.appmap.model;

import com.example.appmap.model.location.UserLocation;

import javax.persistence.*;

@Entity
public class UserCar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(optional = false)
    private UserLocation userLocation;

    @ManyToOne(optional = false)
    private Car car;
}
