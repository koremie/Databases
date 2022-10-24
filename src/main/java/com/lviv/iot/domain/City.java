package com.lviv.iot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class City {
    private Integer id;
    private String name;
    private Integer regionId;
}
