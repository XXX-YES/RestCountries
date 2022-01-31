package com.example.restcountries.repository;

import com.example.restcountries.entity.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Repository
public class CountriesRepository implements CountryRepository {

    private WebClient webClient;

    @Autowired
    public CountriesRepository(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public Flux<Country> getCountries(String name) {
        String url = "/all";
        if (!name.equals("all")){
            url = String.format("/name/%s?fullText=true",name);
        }
        return webClient.get()
                .uri(url, name)
                .retrieve()
                .bodyToFlux(Country.class);

    }
}
