package com.lviv.iot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CashLoad {
    private Integer id;
    private Integer vendingMachineId;
    private Integer serviceStaffId;
    private Float amount;
    private String date;
}
