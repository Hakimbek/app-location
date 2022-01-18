package com.example.appmap.repository;

import com.example.appmap.model.location.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Integer> {

    Boolean existsByCountry(String country);

    Boolean existsByCountryAndIdNot(String country, Integer id);
}
