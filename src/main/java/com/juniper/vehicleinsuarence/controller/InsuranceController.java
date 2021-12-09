package com.juniper.vehicleinsuarence.controller;

import com.juniper.vehicleinsuarence.payload.request.InsuranceReqDto;
import com.juniper.vehicleinsuarence.payload.responce.InsuranceResDto;
import com.juniper.vehicleinsuarence.service.InsuranceService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/insurance")
public class InsuranceController {

    @Autowired
    InsuranceService insuranceService;

    @ApiOperation("saving insurance")
    @PostMapping("/saveInsurance")
    public ResponseEntity saveInsurances(@RequestBody InsuranceReqDto insuranceReqDto)
    {
        return ResponseEntity.ok(insuranceService.saveIncurance(insuranceReqDto));
    }

    @ApiOperation("getting one insurance by insurance number")
    @GetMapping("/getOneInsurance/{number}")
    public ResponseEntity getOneInsurances(@PathVariable String number)
    {
        return ResponseEntity.ok(insuranceService.getOneInsurance(number));
    }

    @ApiOperation("getting all outdated insurances")
    @GetMapping("/getAllBrokens")
    public List<InsuranceResDto> getBrokenInsuranse()
    {
        return insuranceService.getAllBrokenInsurances();
    }

    @ApiOperation("gtetting all not outdated insuranses")
    @GetMapping("/getAllNotbrokenInsurance")
    public List<InsuranceResDto> getAllNotOutdatedInsurance()
    {
        return insuranceService.getAllNotBrokenInsuranse();
    }

    @ApiOperation("updating insurance")
    @PutMapping("/updateInsurance")
    public ResponseEntity updateInsurances(@RequestBody InsuranceReqDto insuranceReqDto)
    {
        return ResponseEntity.ok(insuranceService.updateInsurance(insuranceReqDto));
    }

    @ApiOperation("deleting insurance")
    @DeleteMapping("/delete/{number}")
    public ResponseEntity deleteInsurances(@PathVariable String number)
    {
        return ResponseEntity.ok(insuranceService.deleteInsurance(number));
    }

    @ApiOperation("generating insurance number")
    @GetMapping("/generateNumvber")
    public ResponseEntity genrateNumber()
    {
        return ResponseEntity.ok(insuranceService.generateInsuranceNumber());
    }
}
