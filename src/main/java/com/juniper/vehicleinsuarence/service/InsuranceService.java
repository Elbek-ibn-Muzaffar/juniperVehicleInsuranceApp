package com.juniper.vehicleinsuarence.service;

import com.juniper.vehicleinsuarence.domains.Insurance;
import com.juniper.vehicleinsuarence.domains.Users;
import com.juniper.vehicleinsuarence.domains.Vehicle;
import com.juniper.vehicleinsuarence.payload.request.InsuranceReqDto;
import com.juniper.vehicleinsuarence.payload.responce.InsuranceResDto;
import com.juniper.vehicleinsuarence.payload.responce.VehicleResDto;
import com.juniper.vehicleinsuarence.repository.InsuranseRepository;
import com.juniper.vehicleinsuarence.repository.UserRepository;
import com.juniper.vehicleinsuarence.repository.VehicleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsuranceService {

    @Autowired
    InsuranseRepository insuranseRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    VehicleRepository vehicleRepository;

    ModelMapper modelMapper=new ModelMapper();


    //save insurance function
    public String saveIncurance(InsuranceReqDto insuranceReqDto)
    {

        Insurance insurance=new Insurance();

        if (userRepository.existsByPasport(insuranceReqDto.getPasport())&&vehicleRepository.existsByVnumber(insuranceReqDto.getV_number())) {

            Users users=userRepository.findByPasport(insuranceReqDto.getPasport());

            Vehicle vehicle=vehicleRepository.findByVnumber(insuranceReqDto.getV_number());

            insurance.setProvider(insuranceReqDto.getProvider());
            insurance.setInNumber(insuranceReqDto.getInNumber());
            insurance.setDate(insuranceReqDto.getDate());
            insurance.setUsers(users);
            insurance.setVehicle(vehicle);

            insuranseRepository.save(insurance);

            return "saqlandi";
        }

        return "saqlanmadi user yoki transport mavjud emas";
    }


    //get insurance
    public InsuranceResDto getOneInsurance(String number)
    {
        if (insuranseRepository.existsByInNumber(number))
        {
            return insuranseRepository.getOneVehicleByInNumber(number);
        }

        return new InsuranceResDto();
    }

    //getting all outdated insurances
    public List<InsuranceResDto> getAllBrokenInsurances()
    {
        return insuranseRepository.getBrokenProduct();
    }


    //get all not outdated insurances
    public List<InsuranceResDto> getAllNotBrokenInsuranse()
    {
        return insuranseRepository.getAllNotExpiredInsurance();
    }



    public String updateInsurance(InsuranceReqDto insuranceReqDto)
    {

        if (userRepository.existsByPasport(insuranceReqDto.getPasport())&&vehicleRepository.existsByVnumber(insuranceReqDto.getV_number())&&insuranseRepository.existsByInNumber(insuranceReqDto.getInNumber()))
        {

            Users users=userRepository.findByPasport(insuranceReqDto.getPasport());

            Vehicle vehicle=vehicleRepository.findByVnumber(insuranceReqDto.getV_number());

           Insurance insurance=insuranseRepository.findByInNumber(insuranceReqDto.getInNumber());
           insurance.setVehicle(vehicle);
           insurance.setDate(insuranceReqDto.getDate());
           insurance.setUsers(users);
           insurance.setProvider(insuranceReqDto.getProvider());
           insurance.setInNumber(insuranceReqDto.getInNumber());

           insuranseRepository.save(insurance);
           return "yangilandi";

        }

        return "not updated";
    }


    public String deleteInsurance(String number)
    {
        insuranseRepository.delete(insuranseRepository.findByInNumber(number));
        return "deleted";
    }


}
