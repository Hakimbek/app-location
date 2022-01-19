package com.example.appmap.repository;

import com.example.appmap.model.location.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegionRepository extends JpaRepository<Region, Integer> {

    Boolean existsByRegionAndCountry_Id(String region, Integer country_id);

    Boolean existsByRegionAndCountry_IdAndIdNot(String region, Integer country_id, Integer id);

    List<Region> getAllByCountry_Id(Integer country_id);

}
