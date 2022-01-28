package com.example.restcountries.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class CountriesWebClient {

    private String restCountriesBaseUrl;

    public CountriesWebClient(@Value("${rest_countries.base_url}") String restCountriesBaseUrl) {
        this.restCountriesBaseUrl = restCountriesBaseUrl;
    }
    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .baseUrl(restCountriesBaseUrl)
                .build();
    }
}
