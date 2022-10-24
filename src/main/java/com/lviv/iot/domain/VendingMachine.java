package com.lviv.iot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VendingMachine {
    private Integer id;
    private String machineModelName;
    private String GPS;
    private Integer addressId; 
    private String contactNumber;
    private Boolean isOutOfOrder;
    private Boolean isEmpty;
}
