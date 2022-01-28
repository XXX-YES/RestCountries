
package com.example.restcountries.entity;

import lombok.*;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Currency {

    private String code;
    private String name;
    private String symbol;

}
