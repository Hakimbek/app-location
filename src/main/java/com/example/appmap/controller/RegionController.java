package com.example.appmap.controller;

import com.example.appmap.model.location.Region;
import com.example.appmap.payload.RegionDto;
import com.example.appmap.payload.Result;
import com.example.appmap.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(("/api/region"))
public class RegionController {

    @Autowired
    RegionService regionService;

    // get all regions
    @GetMapping
    public ResponseEntity<List<Region>> get() {
        return ResponseEntity.ok().body(regionService.get());
    }

    // get region by id
    @GetMapping("/{id}")
    public ResponseEntity<Result> getById(@PathVariable Integer id) {
        Result result = regionService.getById(id);
        return ResponseEntity.status(result.isSuccessful() ? 200 : 409).body(result);
    }

    // delete region by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Result> delete(@PathVariable Integer id) {
        Result result = regionService.delete(id);
        return ResponseEntity.status(result.isSuccessful() ? 200 : 405).body(result);
    }

    // add region
    @PostMapping
    public ResponseEntity<Result> post(@Valid @RequestBody RegionDto regionDto) {
        Result result = regionService.add(regionDto);
        return ResponseEntity.status(result.isSuccessful() ? 201 : 409).body(result);
    }

    // put region by id
    @PutMapping("/{id}")
    public ResponseEntity<Result> put(@PathVariable Integer id, @Valid @RequestBody RegionDto regionDto) {
        Result result = regionService.put(regionDto, id);
        return ResponseEntity.status(result.isSuccessful() ? 202 : 409).body(result);
    }
}
