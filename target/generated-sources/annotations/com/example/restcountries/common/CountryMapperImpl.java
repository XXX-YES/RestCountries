package com.example.restcountries.common;

import com.example.restcountries.entity.Country;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-28T13:53:19+0800",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 15.0.1 (Oracle Corporation)"
)
@Component
public class CountryMapperImpl implements CountryMapper {

    @Override
    public SimpleCountry toDomainCountry(Country country) {
        if ( country == null ) {
            return null;
        }

        SimpleCountryBuilder simpleCountry = SimpleCountry.builder();

        simpleCountry.name( country.getName() );
        simpleCountry.capital( country.getCapital() );
        simpleCountry.region( country.getRegion() );
        simpleCountry.subregion( country.getSubregion() );
        simpleCountry.population( country.getPopulation() );
        simpleCountry.alpha2Code( country.getAlpha2Code() );
        simpleCountry.area( country.getArea() );

        return simpleCountry.build();
    }
}
