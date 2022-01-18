package com.example.appmap.repository;

import com.example.appmap.model.location.UserLocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLocationRepository extends JpaRepository<UserLocation, Integer> {

}
