package com.juniper.vehicleinsuarence.payload.request;

import lombok.Data;



@Data
public class VehicleReqDto {


    private String category;

    private String vnumber;

    private String manufactory;

    private String color;

    private String pasport;
}
