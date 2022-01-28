package com.example.restcountries.integration;


import com.example.restcountries.entity.SimpleCountry;
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
    public void shouldReturnOkResponseWithBody() {
        //given
        final String countrySearchText = "Finland";
        super.stubPositiveResponse(countrySearchText);

        //when
        webTestClient.get()
                .uri(String.format("/countries/%s", countrySearchText))
                .exchange()
                .expectStatus().isOk() //then
                .expectBodyList(SimpleCountry.class)
                .value(countries -> hasSize(1))
                .value(countries -> countries.get(0), equalTo(buildCountry("Finland","Helsinki",
                        "Europe","Northern Europe",5530719L,"FI",338424.0)));
    }

    @Test
    public void shouldReturnCountryWithNull() {
        //given
        final String invalidCountrySearchText = "invalid_country";
        super.stubNotFoundResponse(invalidCountrySearchText);

        //when
        webTestClient.get()
                .uri(String.format("/countries/%s", invalidCountrySearchText))
                .exchange()
                .expectStatus().isOk() //then
                .expectBodyList(SimpleCountry.class)
                .value(countries -> hasSize(1))
                .value(countries -> countries.get(0), equalTo(buildCountry(null,null,
                        null,null,null,null,null)));
    }
}