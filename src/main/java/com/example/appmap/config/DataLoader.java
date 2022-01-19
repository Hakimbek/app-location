package com.example.appmap.config;

import com.example.appmap.model.location.City;
import com.example.appmap.model.location.Country;
import com.example.appmap.model.location.Region;
import com.example.appmap.repository.CityRepository;
import com.example.appmap.repository.CountryRepository;
import com.example.appmap.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    RegionRepository regionRepository;

    @Autowired
    CountryRepository countryRepository;

    @Autowired
    CityRepository cityRepository;

    @Value(value = "${spring.sql.init.mode}")
    private String initialMode;

    @Override
    public void run(String... args) throws Exception {
        if (initialMode.equals("always")) {

        }
    }

}
