package com.lviv.iot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Snack {
    private Integer id;
    private String name;
    private Float netWeight;
    private String trademarkName;
}
