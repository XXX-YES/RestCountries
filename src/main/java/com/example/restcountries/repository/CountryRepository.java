package com.example.restcountries.repository;

import com.example.restcountries.entity.SimpleCountry;
import reactor.core.publisher.Flux;

public interface CountryRepository {
    Flux<SimpleCountry> getCountries(String name);
}
