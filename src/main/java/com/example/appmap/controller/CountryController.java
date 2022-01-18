package com.example.appmap.controller;

import com.example.appmap.model.location.Country;
import com.example.appmap.payload.CountryDto;
import com.example.appmap.payload.Result;
import com.example.appmap.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/country")
public class CountryController {

    @Autowired
    CountryService countryService;

    // get all
    @GetMapping
    public ResponseEntity<List<Country>> get() {
        return ResponseEntity.ok().body(countryService.get());
    }

    // get by id
    @GetMapping("/{id}")
    public ResponseEntity<Result> getById(@PathVariable Integer id) {
        Result result = countryService.getById(id);
        return ResponseEntity.status(result.isSuccessful() ? 200 : 409).body(result);
    }

    // delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Result> delete(@PathVariable Integer id) {
        Result result = countryService.delete(id);
        return ResponseEntity.status(result.isSuccessful() ? 200 : 405).body(result);
    }

    // add
    @PostMapping
    public ResponseEntity<Result> add(@Valid @RequestBody CountryDto countryDto) {
        Result result = countryService.add(countryDto);
        return ResponseEntity.status(result.isSuccessful() ? 201 : 409).body(result);
    }

    // put
    @PutMapping("/{id}")
    public ResponseEntity<Result> edit(@PathVariable Integer id, @Valid @RequestBody CountryDto countryDto) {
        Result result = countryService.edit(countryDto, id);
        return ResponseEntity.status(result.isSuccessful() ? 202 : 409).body(result);
    }

}
