package com.juniper.vehicleinsuarence.payload.responce;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleResDto {
    private String category;

    private String vnumber;

    private String manufactory;

    private String color;

    private String ownerName;

    private String ownerLastName;
}
