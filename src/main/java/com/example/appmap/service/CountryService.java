package com.example.appmap.service;

import com.example.appmap.model.location.Country;
import com.example.appmap.payload.CountryDto;
import com.example.appmap.payload.Result;
import com.example.appmap.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    CountryRepository countryRepository;

    // get
    public List<Country> get() {
        return countryRepository.findAll();
    }

    // get by id
    public Result getById(int id) {
        Optional<Country> optionalCountry = countryRepository.findById(id);
        if (optionalCountry.isEmpty()) {
            return new Result("Country with id=" + id + " does not exist", false);
        } else {
            return new Result("Success", true, optionalCountry.get());
        }
    }

    // delete by id
    public Result delete(int id) {
        try {
            countryRepository.deleteById(id);
            return new Result("Country is deleted successfully.", true);
        } catch (Exception e) {
            return new Result("Error. Country is not deleted.", false);
        }
    }

    // add country
    public Result add(CountryDto countryDto) {
        if (countryRepository.existsByCountry(countryDto.getCountry())) {
            return new Result("This country name already exist.", false);
        } else {
            Country country = new Country();
            country.setCountry(countryDto.getCountry());
            countryRepository.save(country);
            return new Result("Country is added successfully.", true);
        }
    }

    // put country
    public Result edit(CountryDto countryDto, int id) {
        if (countryRepository.existsByCountryAndIdNot(countryDto.getCountry(), id)) {
            return new Result("This country already exist.", false);
        } else {
            Optional<Country> optionalCountry = countryRepository.findById(id);
            if (optionalCountry.isEmpty()) {
                return new Result("Country with id=" + id + " does not exist.", false);
            } else {
                Country country = optionalCountry.get();
                country.setCountry(countryDto.getCountry());
                countryRepository.save(country);
                return new Result("Country is edited successfully.", true, country);
            }
        }
    }
}
