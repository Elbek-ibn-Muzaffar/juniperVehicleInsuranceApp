package com.juniper.vehicleinsuarence.payload.responce;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InsuranceResDto {

    private String provider;

    private String inNumber;

    @Temporal(TemporalType.DATE)
    private Date date;

    private String vnumber;

    private String vmanufactory;

    private String ovnerName;

    private String ovnerLastName;

}
