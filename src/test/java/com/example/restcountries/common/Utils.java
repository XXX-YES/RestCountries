package com.example.restcountries.common;

import com.example.restcountries.entity.SimpleCountry;

public class Utils {


    public static SimpleCountry buildCountry(String name, String capital,
                                             String region, String subregion,
                                             Long population, String alpha2Code,
                                             Double area) {
        return SimpleCountry.builder()
                .name(name)
                .capital(capital)
                .region(region)
                .subregion(subregion)
                .population(population)
                .alpha2Code(alpha2Code)
                .area(area)
                .build();
    }
}
