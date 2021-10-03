package com.juniper.vehicleinsuarence.payload.request;

import lombok.Data;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
public class InsuranceReqDto {

    private String provider;

    private String inNumber;

    @Temporal(TemporalType.DATE)
    private Date date;

    private String v_number;

    private String pasport;
}
