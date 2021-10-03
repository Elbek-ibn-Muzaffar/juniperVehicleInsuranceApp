package com.juniper.vehicleinsuarence.service;

import com.juniper.vehicleinsuarence.domains.Users;
import com.juniper.vehicleinsuarence.domains.Vehicle;
import com.juniper.vehicleinsuarence.payload.request.VehicleReqDto;
import com.juniper.vehicleinsuarence.payload.responce.VehicleResDto;
import com.juniper.vehicleinsuarence.repository.UserRepository;
import com.juniper.vehicleinsuarence.repository.VehicleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class VehicleService {

    @Autowired
    VehicleRepository vehicleRepository;

    @Autowired
    UserRepository userRepository;

    ModelMapper modelMapper=new ModelMapper();


    //save vehicle
    public String saveVehicle(VehicleReqDto vehicleReqDto)
    {
        Users users=userRepository.findByPasport(vehicleReqDto.getPasport());
        Vehicle vehicle=new Vehicle();

        if (!vehicleRepository.existsByVnumber(vehicleReqDto.getVnumber()))
        {
            vehicle.setCategory(vehicleReqDto.getCategory());
            vehicle.setColor(vehicleReqDto.getColor());
            vehicle.setManufactory(vehicleReqDto.getManufactory());
            vehicle.setVnumber(vehicleReqDto.getVnumber());
            vehicle.setUsers(users);

            vehicleRepository.save(vehicle);
            return "saqlandi";
        }

        return "saqlanmadi bu avtomashina mavjud";
    }

    //get One Vehicle
    public VehicleResDto getOneVehicle(String number)
    {
        if (vehicleRepository.existsByVnumber(number))
        {
            return vehicleRepository.getVehicleByNumber(number);
        }

        return new VehicleResDto();
    }


    public List<VehicleResDto> getAllVehicles()
    {
        List<Vehicle> vehicles=vehicleRepository.findAll();
        List<Users> users=userRepository.findAll();
        List<VehicleResDto> vehicleResDtos=new LinkedList<>();
        for (int i=0;i<vehicles.size();i++)
        {
            vehicleResDtos.add(modelMapper.map(vehicles.get(i),VehicleResDto.class));
            vehicleResDtos.get(i).setOwnerName(users.get(i).getName());
            vehicleResDtos.get(i).setOwnerLastName(users.get(i).getLastName());
        }

        return vehicleResDtos;
    }


    //update vehicle
    public String updateVehicle(VehicleReqDto vehicleReqDto)
    {
        Vehicle vehicle=vehicleRepository.findByVnumber(vehicleReqDto.getVnumber());
//        Users users=userRepository.findByPasport(vehicleReqDto.getPasport());

        vehicle.setVnumber(vehicleReqDto.getVnumber());
        vehicle.setCategory(vehicleReqDto.getCategory());
        vehicle.setManufactory(vehicleReqDto.getManufactory());
        vehicle.setColor(vehicleReqDto.getColor());
        vehicleRepository.save(vehicle);

        return "Yangilandi";
    }

    //delete vehicle
    public String deleteVehicle(String vnumber)
    {
        Vehicle vehicle=vehicleRepository.findByVnumber(vnumber);
        vehicleRepository.delete(vehicle);
        return "O'chirildi";
    }


}
