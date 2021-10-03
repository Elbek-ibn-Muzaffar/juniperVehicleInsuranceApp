package com.juniper.vehicleinsuarence.payload;

import lombok.Data;

@Data
public class AuthRequest {
    private String name;
    private String password;
}
