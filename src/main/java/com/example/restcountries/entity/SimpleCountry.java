package com.example.restcountries.entity;

import lombok.*;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class SimpleCountry {

    private String name;
    private String capital;
    private String region;
    private String subregion;
    private Long population;
    private String alpha2Code;
    private Double area;

}
