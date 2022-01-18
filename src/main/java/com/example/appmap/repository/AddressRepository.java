package com.example.appmap.repository;

import com.example.appmap.model.location.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
