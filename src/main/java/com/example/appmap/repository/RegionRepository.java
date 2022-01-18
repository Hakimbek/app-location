package com.example.appmap.repository;

import com.example.appmap.model.location.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepository extends JpaRepository<Region, Integer> {

    Boolean existsByRegion(String region);

    Boolean existsByRegionAndIdNot(String region, Integer id);

}
