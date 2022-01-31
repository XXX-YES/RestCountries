package com.example.restcountries.service;

import com.example.restcountries.entity.Country;
import reactor.core.publisher.Flux;

public interface CountryService {

    Flux<Country> getCountries(String name);
}
