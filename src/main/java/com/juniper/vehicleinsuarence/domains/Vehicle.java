package com.juniper.vehicleinsuarence.domains;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String category;

    private String vnumber;

    private String manufactory;

    private String color;

    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    private Date cratedDate;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Users users;

}
