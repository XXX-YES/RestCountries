
package com.example.restcountries.entity;

import lombok.*;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Language {

    private String iso6391;
    private String iso6392;
    private String name;
    private String nativeName;

}
