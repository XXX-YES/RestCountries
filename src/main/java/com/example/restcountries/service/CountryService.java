package com.example.restcountries.service;

import com.example.restcountries.entity.SimpleCountry;
import reactor.core.publisher.Flux;

public interface CountryService {

    Flux<SimpleCountry> getCountries(String name);
}
