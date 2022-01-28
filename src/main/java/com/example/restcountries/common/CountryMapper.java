package com.example.restcountries.common;

import com.example.restcountries.entity.Country;
import com.example.restcountries.entity.SimpleCountry;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CountryMapper {

    CountryMapper INSTANCE = Mappers.getMapper(CountryMapper.class);

    SimpleCountry toDomainCountry(Country country);
}
