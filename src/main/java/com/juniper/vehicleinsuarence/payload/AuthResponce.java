package com.juniper.vehicleinsuarence.payload;

import jdk.jfr.Name;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
//@NoArgsConstructor
public class AuthResponce {
    private final  String jwt;
}
