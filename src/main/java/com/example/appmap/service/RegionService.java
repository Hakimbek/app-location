package com.example.appmap.service;

import com.example.appmap.model.location.Country;
import com.example.appmap.model.location.Region;
import com.example.appmap.payload.RegionDto;
import com.example.appmap.payload.Result;
import com.example.appmap.repository.CountryRepository;
import com.example.appmap.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegionService {

    @Autowired
    RegionRepository regionRepository;

    @Autowired
    CountryRepository countryRepository;

    // add new region
    public Result add(RegionDto regionDto) {
        if (regionRepository.existsByRegionAndCountry_Id(regionDto.getRegionName(), regionDto.getCountryId())) {
            return new Result("This region name already exist in this country", false, null);
        }

        Optional<Country> countryOptional = countryRepository.findById(regionDto.getCountryId());
        if (countryOptional.isEmpty()) {
            return new Result("Country with id=" + regionDto.getCountryId() + " does not exist");
        }

        Region region = new Region();
        region.setRegion(regionDto.getRegionName());
        region.setCountry(countryOptional.get());
        regionRepository.save(region);
        return new Result("Region is added successfully.", true, region);
    }

    // get by country id
    public List<Region> getByCountryId(int id) {
        return regionRepository.getAllByCountry_Id(id);
    }

    // get by id region id
    public Result getByRegionId(int id) {
        Optional<Region> optionalRegion = regionRepository.findById(id);
        if (optionalRegion.isEmpty()) {
            return new Result("Region with id=" + id + " does not exist.", false);
        } else {
            return new Result("Success", true, optionalRegion.get());
        }
    }

    // get all regions
    public List<Region> get() {
        return regionRepository.findAll();
    }

    // delete region by id
    public Result delete(int id) {
        try {
            regionRepository.deleteById(id);
            return new Result("Region is deleted successfully.", true);
        } catch (Exception e) {
            return new Result("Error. Region is not deleted.", false);
        }
    }

    // put region by id
    public Result put(RegionDto regionDto, int id) {
        Optional<Region> optionalRegion = regionRepository.findById(id);
        if (optionalRegion.isEmpty()) {
            return new Result("Region name with id=" + id + " does not exist", false);
        }

        if (regionRepository.existsByRegionAndCountry_IdAndIdNot(regionDto.getRegionName(), regionDto.getCountryId(), id)) {
            return new Result("This region name already exist in this country", false);
        }

        Optional<Country> optionalCountry = countryRepository.findById(regionDto.getCountryId());
        if (optionalCountry.isEmpty()) {
            return new Result("Country with id=" + regionDto.getCountryId() + " does not exist", false);
        }
        Country country = optionalCountry.get();

        Region region = optionalRegion.get();
        region.setRegion(regionDto.getRegionName());
        region.setCountry(country);
        regionRepository.save(region);
        return new Result("Region is edited successfully", true);
    }

}
