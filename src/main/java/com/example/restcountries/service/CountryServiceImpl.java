package com.example.restcountries.service;

import com.example.restcountries.entity.Country;
import com.example.restcountries.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class CountryServiceImpl implements CountryService {

    private CountryRepository countryRepository;

    @Autowired
    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public Flux<Country> getCountries(String name) {
        return countryRepository.getCountries(name);
    }
}
