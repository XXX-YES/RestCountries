package com.example.restcountries.integration;


import com.example.restcountries.entity.Country;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.test.web.reactive.server.WebTestClient;


import static com.example.restcountries.common.Utils.buildCountry;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

@AutoConfigureWebTestClient
@DisplayName("Integration tests for CountryController")
public class CountryControllerIT extends BaseIntegrationTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void shouldReturnCountryWithAttributes() {
        //given
        final String countrySearchText = "Finland";
        super.stubPositiveResponse(countrySearchText);

        //when
        webTestClient.get()
                .uri(String.format("/name/%s", countrySearchText))
                .exchange()
                .expectStatus().isOk() //then
                .expectBodyList(Country.class)
                .value(countries -> hasSize(1))
                .value(countries -> countries.get(0), equalTo(buildCountry(true)));

    }

    @Test
    public void shouldReturnCountryWithNull() {
        //given
        final String invalidCountrySearchText = "invalid_country";
        super.stubNotFoundResponse(invalidCountrySearchText);

        //when
        webTestClient.get()
                .uri(String.format("/name/%s", invalidCountrySearchText))
                .exchange()
                .expectStatus().isOk() //then
                .expectBodyList(Country.class)
                .value(countries -> hasSize(1))
                .value(countries -> countries.get(0), equalTo(buildCountry(false)));
    }
}