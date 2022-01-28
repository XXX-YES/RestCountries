package com.example.restcountries.unit;

import com.example.restcountries.common.CountriesWebClient;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("Unit tests for RestCountriesWebClient")
public class CountriesWebClientTest {

    private static final String A_BASE_URL = "http://localhost:8080";

    //sut
    private CountriesWebClient restCountriesWebClient = new CountriesWebClient(A_BASE_URL);

    @Test
    public void shouldBuildWebClient() {
        WebClient webClient = restCountriesWebClient.webClient();
        assertNotNull(webClient);
    }

}
