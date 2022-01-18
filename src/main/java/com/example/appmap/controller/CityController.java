package com.example.appmap.controller;

import com.example.appmap.model.location.City;
import com.example.appmap.payload.CityDto;
import com.example.appmap.payload.Result;
import com.example.appmap.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/city")
public class CityController {

    @Autowired
    CityService cityService;

    // get all
    @GetMapping
    public ResponseEntity<List<City>> get() {
        return ResponseEntity.ok().body(cityService.get());
    }

    // get by id
    @GetMapping("/{id}")
    public ResponseEntity<Result> getById(@PathVariable Integer id) {
        Result result = cityService.getById(id);
        return ResponseEntity.status(result.isSuccessful() ? 200 : 409).body(result);
    }


    // delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Result> delete(@PathVariable Integer id) {
        Result result = cityService.delete(id);
        return ResponseEntity.status(result.isSuccessful() ? 200 : 405).body(result);
    }

    // add
    @PostMapping
    public ResponseEntity<Result> add(@RequestBody CityDto cityDto) {
        Result result = cityService.add(cityDto);
        return ResponseEntity.status(result.isSuccessful() ? 201 : 409).body(result);
    }

    // edit
    @PutMapping("/{id}")
    public ResponseEntity<Result> edit(@PathVariable Integer id, @RequestBody CityDto cityDto) {
        Result result = cityService.edit(cityDto, id);
        return ResponseEntity.status(result.isSuccessful() ? 202 : 409).body(result);
    }
}



















