package com.example.appmap.repository;

import com.example.appmap.model.location.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Integer> {

    Boolean existsByCity(String city);

    Boolean existsByCityAndIdNot(String city, Integer id);

}
