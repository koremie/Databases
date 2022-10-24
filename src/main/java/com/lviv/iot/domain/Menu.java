package com.lviv.iot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Menu {
    private Integer vendingMachineId;
    private Integer slotNumber;
    private Integer snackId;
    private Integer quantity;
    private Float pricePerUnit;
}
