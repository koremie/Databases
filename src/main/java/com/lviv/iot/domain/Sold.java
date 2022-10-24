package com.lviv.iot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Sold {
    private Integer id;
    private Integer menuVendingMachineId;
    private Integer menuSlotNumber;
    private String time;
}
