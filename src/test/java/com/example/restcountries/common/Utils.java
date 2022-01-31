package com.example.restcountries.common;

import com.example.restcountries.entity.Country;

import java.util.*;

public class Utils {


    public static Country buildCountry(boolean entity) {

        String name = "Finland";

        List<String> topLevelDomain = new ArrayList<>();
        topLevelDomain.add(".fi");


        String alpha2Code = "FI";
        String alpha3Code = "FIN";

        List<String> callingCodes = new ArrayList<>();
        callingCodes.add("358");

        String capital = "Helsinki";

        List<String> altSpellings = new ArrayList<>();
        altSpellings.add("FI");
        altSpellings.add("Suomi");
        altSpellings.add("Republic of Finland");
        altSpellings.add("Suomen tasavalta");
        altSpellings.add("Republiken Finland");

        String region = "Europe";
        String subregion = "Northern Europe";

        Long population = 5530719L;

        List<Double> latlng = new ArrayList<>();
        latlng.add(64.0);
        latlng.add(26.0);

        String demonym = "Finnish";

        Double area = 338424.0;

        String flag = "https://flagcdn.com/fi.svg";

        Double gini = 27.3;


        List<String> timezones = new ArrayList<>();
        timezones.add("UTC+02:00");

        List<String> borders = new ArrayList<>();
        borders.add("NOR");
        borders.add("SWE");
        borders.add("RUS");

        String nativeName = "Suomi";
        String numericCode = "246";

//        List<Map<?,?>> currencies = new ArrayList<>();
//        Map<String, String> currencies_1 = new HashMap<>();
//        currencies_1.put("code", "EUR");
//        currencies_1.put("name", "Euro");
//        currencies_1.put("symbol", "€");
//        currencies.add(currencies_1);
//
//
//        List<Map<?,?>> languages = new ArrayList<>();
//        Map<String, String> languages_1 = new HashMap<>();
//        languages_1.put("iso639_1", "fi");
//        languages_1.put("iso639_2", "fin");
//        languages_1.put("name", "Finnish");
//        languages_1.put("nativeName", "suomi");
//        languages.add(languages_1);
//
//        Map<String, String> languages_2 = new HashMap<>();
//        languages_2.put("iso639_1", "sv");
//        languages_2.put("iso639_2", "swe");
//        languages_2.put("name", "Swedish");
//        languages_2.put("nativeName", "svenska");
//        languages.add(languages_2);
//
//
//        List<Map<?,?>> translations = new ArrayList<>();
//        Map<String, String> translations_1 = new HashMap<>();
//        translations_1.put("br", "Finlândia");
//        translations_1.put("pt", "Finlândia");
//        translations_1.put("nl", "Finland");
//        translations_1.put("hr", "Finska");
//        translations_1.put("fa", "فنلاند");
//        translations_1.put("de", "Finnland");
//        translations_1.put("es", "Finlandia");
//        translations_1.put("fr", "Finlande");
//        translations_1.put("ja", "フィンランド");
//        translations_1.put("hu", "Finnország");
//        translations.add(translations_1);
//
//
//
//        Map<String, String> flags = new HashMap<>();
//        flags.put("svg", "https://flagcdn.com/fi.svg");
//        flags.put("png", "https://flagcdn.com/w320/fi.png");
//
//        List<Map<?,?>> regionalBlocs = new ArrayList<>();
//        Map<String, String> regionalBlocs_1 = new HashMap<>();
//        regionalBlocs_1.put("acronym", "EU");
//        regionalBlocs_1.put("name", "European Union");
//        regionalBlocs.add(regionalBlocs_1);

        String cioc = "FIN";

        if (entity){
            return Country.builder()
                    .name(name)
                    .topLevelDomain(topLevelDomain)
                    .alpha2Code(alpha2Code)
                    .alpha3Code(alpha3Code)
                    .callingCodes(callingCodes)
                    .capital(capital)
                    .region("Europe")
                    .altSpellings(altSpellings)
                    .region(region)
                    .subregion(subregion)
                    .population(population)
                    .latlng(latlng)
                    .demonym(demonym)
                    .area(area)
                    .flag(flag)
                    .gini(gini)
                    .timezones(timezones)
                    .borders(borders)
                    .nativeName(nativeName)
                    .numericCode(numericCode)
//                    .currencies(currencies)
//                    .languages(languages)
//                    .translations(translations)
//                    .flags(flags)
//                    .regionalBlocs(regionalBlocs)
                    .cioc(cioc)
                    .build();
        }else {
            return Country.builder().build();
        }

    }
}


