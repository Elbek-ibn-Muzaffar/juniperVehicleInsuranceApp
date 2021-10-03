package com.juniper.vehicleinsuarence.payload.request;

import com.sun.istack.NotNull;
import lombok.Data;

import java.util.Set;

@Data
public class UserReqDto {
    private String name;

    private String lastName;

    private String licenceNo;

    private String password;

    private String pasport;

    private Set<RoleDto> roles;

}
