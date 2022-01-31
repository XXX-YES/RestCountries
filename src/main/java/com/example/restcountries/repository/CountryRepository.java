package com.example.restcountries.repository;

import com.example.restcountries.entity.Country;
import reactor.core.publisher.Flux;

public interface CountryRepository {
    Flux<Country> getCountries(String name);
}
