package com.lviv.iot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Address {
    private Integer id;
    private Integer cityId;
    private String street;
    private String houseNumber;
    private Integer appartmentNumber;
}
