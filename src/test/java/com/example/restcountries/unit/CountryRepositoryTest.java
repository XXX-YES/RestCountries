package com.example.restcountries.unit;

import com.example.restcountries.common.MockServerBaseTest;
import com.example.restcountries.entity.Country;
import com.example.restcountries.repository.CountryRepository;
import com.example.restcountries.repository.CountriesRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.List;

import static com.example.restcountries.common.Utils.buildCountry;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Unit tests for CountryRepository")
public class CountryRepositoryTest extends MockServerBaseTest {

    //sut
    private CountryRepository countryRepository = new CountriesRepository(WebClient.create("https://restcountries.com/v2"));


    @Test
    public void shouldReturnCountryList() {
        //given
        final String countrySearchText = "Finland";
        super.stubPositiveResponse(countrySearchText);

        //when
        Flux<Country> countries = countryRepository.getCountries(countrySearchText);
        List<Country> list1 = countries.collectList().block();

        System.out.println(list1.get(0).toString());

        //then
        StepVerifier.create(countries)
                .expectNext(buildCountry(true))
                .verifyComplete();
    }

    @Test
    public void shouldReturnCountryWithNull() {
        //given
        final String invalidCountrySearchText = "invalid_country";
        super.stubNotFoundResponse(invalidCountrySearchText);

        //when
        Flux<Country> countries = countryRepository.getCountries(invalidCountrySearchText);


        StepVerifier.create(countries)
                .expectNext(buildCountry(false))
                .verifyComplete();


    }

}
