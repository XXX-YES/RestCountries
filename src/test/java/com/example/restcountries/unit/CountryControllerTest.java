package com.example.restcountries.unit;

import com.example.restcountries.controller.CountryController;
import com.example.restcountries.entity.SimpleCountry;
import com.example.restcountries.service.CountryService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import static com.example.restcountries.common.Utils.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
@DisplayName("Unit tests for CountryController")
public class CountryControllerTest {

    @Mock
    private CountryService countryService;

    //sut
    @InjectMocks
    private CountryController countryController;

    @Test
    public void shouldReturnOkResponseWithBody() {
        final String countrySearchName = "Finland";
        Flux<SimpleCountry> countryFlux = Flux.just(buildCountry("Finland","Helsinki",
                "Europe","Northern Europe",5530719L,"FI",338424.0));
        Mockito.when(countryService.getCountries(countrySearchName)).thenReturn(countryFlux);

        ResponseEntity<Flux<SimpleCountry>> httpResponse = countryController.getCountryByName(countrySearchName);

        assertEquals(HttpStatus.OK, httpResponse.getStatusCode());
        StepVerifier.create(httpResponse.getBody())
                .expectNext(buildCountry("Finland","Helsinki",
                        "Europe","Northern Europe",5530719L,"FI",338424.0))
                .verifyComplete();
    }

}
