package com.juniper.vehicleinsuarence.domains;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date date;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Vehicle vehicle;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Users users;
}
