package com.example.restcountries.unit;

import com.example.restcountries.entity.SimpleCountry;
import com.example.restcountries.entity.Country;
import com.example.restcountries.common.CountryMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@DisplayName("Unit test for CountryMapper")
public class CountryMapperTest {

    @Test
    public void shouldMapRepoCountryToDomainCountry() {
        Country repoCountry = buildRepoCountry();
        SimpleCountry domainCountry = CountryMapper.INSTANCE.toDomainCountry(repoCountry);

        assertEquals("Finland", domainCountry.getName());
        assertEquals("Helsinki", domainCountry.getCapital());
        assertEquals("Europe", domainCountry.getRegion());
        assertEquals("Northern Europe", domainCountry.getSubregion());
        assertEquals(5530719L, domainCountry.getPopulation());
        assertEquals(338424.0, domainCountry.getArea());
        assertEquals("FI", domainCountry.getAlpha2Code());


    }

    @Test
    public void shouldNotMapNullSource() {
        SimpleCountry domainCountry = CountryMapper.INSTANCE.toDomainCountry(null);
        assertNull(domainCountry);
    }

    private Country buildRepoCountry() {
        Country country = new Country();
        country.setName("Finland");
        country.setCapital("Helsinki");
        country.setRegion("Europe");
        country.setSubregion("Northern Europe");
        country.setPopulation(5530719L);
        country.setArea(338424.0);
        country.setAlpha2Code("FI");
        return country;
    }
}
