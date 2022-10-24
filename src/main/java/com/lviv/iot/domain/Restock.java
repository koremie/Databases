package com.lviv.iot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Restock {
    private Integer id;
    private Integer menuVendingMachineId;
    private Integer menuSlotNumber;
    private Integer quantity;
    private Integer serviceStaffId;
    private String date;
}
