package com.juniper.vehicleinsuarence.repository;

import com.juniper.vehicleinsuarence.domains.Insurance;
import com.juniper.vehicleinsuarence.payload.responce.InsuranceResDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface InsuranseRepository extends JpaRepository<Insurance, UUID> {

    boolean existsByInNumber(String number);

    @Query("select new com.juniper.vehicleinsuarence.payload.responce.InsuranceResDto(i.provider,i.inNumber,i.date,v.vnumber,v.manufactory,u.name,u.lastName) from Insurance i " +
            "inner join i.users u " +
            "inner join i.vehicle v " +
            "where i.inNumber= :innumber")
    InsuranceResDto getOneVehicleByInNumber(@Param("innumber") String innumber);

    @Modifying
    @Query("select new com.juniper.vehicleinsuarence.payload.responce.InsuranceResDto(i.provider,i.inNumber,i.date,v.vnumber,v.manufactory,u.name,u.lastName) from Insurance i " +
            "inner join i.users u " +
            "inner join i.vehicle v " +
            "where i.date <CURRENT_DATE")
    List<InsuranceResDto> getBrokenProduct();

    @Modifying
    @Query("select new com.juniper.vehicleinsuarence.payload.responce.InsuranceResDto(i.provider,i.inNumber,i.date,v.vnumber,v.manufactory,u.name,u.lastName) from Insurance i " +
            "inner join i.users u " +
            "inner join i.vehicle v " +
            "where i.date >CURRENT_DATE")
    List<InsuranceResDto> getAllNotExpiredInsurance();


    Insurance findByInNumber(String number);

    @Query("select i.inNumber from Insurance i")
    List<String> findAllInNumber();

}
