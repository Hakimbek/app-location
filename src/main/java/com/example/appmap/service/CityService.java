package com.example.appmap.service;

import com.example.appmap.model.location.City;
import com.example.appmap.payload.CityDto;
import com.example.appmap.payload.Result;
import com.example.appmap.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {

    @Autowired
    CityRepository cityRepository;

    // get all
    public List<City> get() {
        return cityRepository.findAll();
    }

    // get by id
    public Result getById(int id) {
        Optional<City> optionalCity = cityRepository.findById(id);
        if (optionalCity.isEmpty()) {
            return new Result("City with id=" + id + " does not exist.", false);
        } else {
            return new Result("Success", true, optionalCity.get());
        }
    }

    // delete
    public Result delete(int id) {
        try {
            cityRepository.deleteById(id);
            return new Result("City is deleted successfully.", true);
        } catch (Exception e) {
            return new Result("Error. City is  not deleted.", false);
        }
    }

    // add
    public Result add(CityDto cityDto) {
        if (cityRepository.existsByCity(cityDto.getCity())) {
            return new Result("This city name already exist.", false);
        } else {
            City city = new City();
            city.setCity(cityDto.getCity());
            cityRepository.save(city);
            return new Result("City is added successfully.", true);
        }
    }

    // put
    public Result edit(CityDto cityDto, int id) {
        if (cityRepository.existsByCityAndIdNot(cityDto.getCity(), id)) {
            return new Result("This city name already exist.", false);
        } else {
            Optional<City> optionalCity = cityRepository.findById(id);
            if (optionalCity.isEmpty()) {
                return new Result("City with id=" + id + " does not exist.", false);
            } else {
                City city = optionalCity.get();
                city.setCity(cityDto.getCity());
                cityRepository.save(city);
                return new Result("City is edited successfully.", true, city);
            }
        }
    }
}



















