
package com.example.restcountries.entity;

import lombok.*;

import java.util.List;
import java.util.Map;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Country {

    private String name;
    private List<String> topLevelDomain ;
    private String alpha2Code;
    private String alpha3Code;
    private List<String> callingCodes;
    private String capital;
    private List<String> altSpellings;
    private String region;
    private String subregion;
    private Long population;
    private List<Double> latlng;
    private String demonym;
    private Double area;
    private String flag;
    private Double gini;
    private List<String> timezones ;
    private List<String> borders;
    private String nativeName;
    private String numericCode;
//    private List<Map<?,?>> currencies;
//    private List<Map<?,?>>  languages;
//    private List<Map<?,?>> translations;
//    private Map<String, String> flags;
//    private List<Map<?,?>>  regionalBlocs ;
    private String cioc;

}
