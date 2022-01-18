package com.example.appmap.service;

import com.example.appmap.model.location.Region;
import com.example.appmap.payload.RegionDto;
import com.example.appmap.payload.Result;
import com.example.appmap.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegionService {

    @Autowired
    RegionRepository regionRepository;

    // add new region
    public Result add(RegionDto regionDto) {
        if (regionRepository.existsByRegion(regionDto.getRegionName())) {
            return new Result("This region name already exist.", false, null);
        } else {
            Region region = new Region();
            region.setRegion(regionDto.getRegionName());
            regionRepository.save(region);
            return new Result("Region is added successfully.", true, region);
        }
    }

    // get region by id
    public Result getById(int id) {
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
        if (regionRepository.existsByRegionAndIdNot(regionDto.getRegionName(), id)) {
            return new Result("This region name already exist.", false);
        } else {
            Optional<Region> optionalRegion = regionRepository.findById(id);
            if (optionalRegion.isEmpty()) {
                return new Result("Region name with id=" + id + " does not exist", false);
            } else {
                Region region = optionalRegion.get();
                region.setRegion(regionDto.getRegionName());
                regionRepository.save(region);
                return new Result("Region name is edited successfully", true);
            }
        }
    }

}
