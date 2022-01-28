package com.example.restcountries.unit;

import com.example.restcountries.entity.SimpleCountry;
import com.example.restcountries.repository.CountryRepository;
import com.example.restcountries.service.CountryServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import static com.example.restcountries.common.Utils.buildCountry;

@ExtendWith(MockitoExtension.class)
@DisplayName("Unit tests for CountryService")
public class CountryServiceTest {

    @Mock
    private CountryRepository countryRepository;

    //sut
    @InjectMocks
    private CountryServiceImpl countryService;

    @Test
    public void shouldReturnCountryList() {
        final String countrySearchName = "Finland";
        Flux<SimpleCountry> countryFlux = Flux.just(buildCountry("Finland","Helsinki",
                "Europe","Northern Europe",5530719L,"FI",338424.0));
        Mockito.when(countryRepository.getCountries(countrySearchName)).thenReturn(countryFlux);

        Flux<SimpleCountry> result = countryService.getCountries(countrySearchName);

        StepVerifier.create(result)
                .expectNext(buildCountry("Finland","Helsinki",
                        "Europe","Northern Europe",5530719L,"FI",338424.0))
                .verifyComplete();

    }

}
