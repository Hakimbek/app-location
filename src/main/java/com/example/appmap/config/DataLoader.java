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
            regionRepository.saveAll(new ArrayList<>(Arrays.asList(
                    new Region("Xorazm"),
                    new Region("Toshkent"),
                    new Region("Samarqand"),
                    new Region("Navoi"),
                    new Region("Buxoro"),
                    new Region("Sirdaryo"),
                    new Region("Qashqdaryo"),
                    new Region("Andijon"),
                    new Region("Frag'ona"),
                    new Region("Jizzax"),
                    new Region("Namangan"),
                    new Region("Surxondaryo"),
                    new Region("Qoraqalpog'siton Res."),
                    new Region("Toshkent vil.")
            )));

            countryRepository.save(new Country("Uzbekistan"));

            cityRepository.saveAll(new ArrayList<>(Arrays.asList(
                    new City("Toshkent"),
                    new City("Samarqand"),
                    new City("Namangan"),
                    new City("Andijon"),
                    new City("Buxoro"),
                    new City("Nukus"),
                    new City("Qarshi"),
                    new City("Urganch")
            )));
        }
    }

}
