package com.juniper.vehicleinsuarence.domains;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
public class Insurance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String provider;

    private String inNumber;

    @Temporal(TemporalType.DATE)
    private Date date;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Vehicle vehicle;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Users users;
}
