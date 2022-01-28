package com.example.restcountries.controller;

import com.example.restcountries.service.CountryService;
import com.example.restcountries.entity.SimpleCountry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@CrossOrigin
@RestController
@RequestMapping("/countries")
public class CountryController {

    private CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping(value = "/{name}")
    public ResponseEntity<Flux<SimpleCountry>> getCountryByName(@PathVariable("name") String name) {
        return ResponseEntity.ok().body(countryService.getCountries(name));
    }

    @GetMapping(value ="")
    public ResponseEntity<Flux<SimpleCountry>> getAllCountries() {
        return ResponseEntity.ok().body(countryService.getCountries("all"));
    }


}
