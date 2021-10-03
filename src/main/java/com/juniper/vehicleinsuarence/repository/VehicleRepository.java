package com.juniper.vehicleinsuarence.repository;

import com.juniper.vehicleinsuarence.domains.Vehicle;
import com.juniper.vehicleinsuarence.payload.responce.VehicleResDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, UUID> {

    boolean existsByVnumber(String number);

    @Query("select new com.juniper.vehicleinsuarence.payload.responce.VehicleResDto(v.category,v.vnumber,v.manufactory,v.color,u.name,u.lastName) from Vehicle v " +
            "inner join v.users u " +
            "where v.vnumber= :number")
    VehicleResDto getVehicleByNumber(@Param("number") String number);

    Vehicle findByVnumber(String number);

}
