package com.juniper.vehicleinsuarence.controller;

import com.juniper.vehicleinsuarence.payload.request.VehicleReqDto;
import com.juniper.vehicleinsuarence.payload.responce.VehicleResDto;
import com.juniper.vehicleinsuarence.service.VehicleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    VehicleService vehicleService;


    @ApiOperation("Saving vehicle")
    @PostMapping("/saveVehicle")
    public ResponseEntity saveVehicle(@RequestBody VehicleReqDto vehicleReqDto)
    {
        return ResponseEntity.ok(vehicleService.saveVehicle(vehicleReqDto));
    }

    @ApiOperation("getting one vehicle")
    @GetMapping("/getVehicle/{number}")
    public ResponseEntity getOneVehicles(@PathVariable String number)
    {
        return ResponseEntity.ok(vehicleService.getOneVehicle(number));
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @ApiOperation("getting all vehicles")
    @GetMapping("/getAllVehicles")
    public List<VehicleResDto> getAllVehicle()
    {
        return vehicleService.getAllVehicles();
    }


    @ApiOperation("updating vehicles")
    @PutMapping("/updateVehicle")
    public ResponseEntity updateVehicles(@RequestBody VehicleReqDto vehicleReqDto)
    {
        return ResponseEntity.ok(vehicleService.updateVehicle(vehicleReqDto));
    }

    @ApiOperation("deleting vehicles by number")
    @DeleteMapping("/deleteVehicle/{vnumber}")
    public ResponseEntity deleteVehicles(@PathVariable String vnumber)
    {
        return ResponseEntity.ok(vehicleService.deleteVehicle(vnumber));
    }
}
