package com.lviv.iot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ServiceStaff {
    private Integer id;
    private String name;
    private String lastName;
    private String workExperience; 
    private Boolean isAvailable;
    private Integer addressId;
}
