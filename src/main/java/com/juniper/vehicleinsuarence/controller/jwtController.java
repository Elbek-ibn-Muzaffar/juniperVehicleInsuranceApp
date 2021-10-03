package com.juniper.vehicleinsuarence.controller;

import com.juniper.vehicleinsuarence.payload.AuthRequest;
import com.juniper.vehicleinsuarence.payload.AuthResponce;
import com.juniper.vehicleinsuarence.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authenticate")
public class jwtController {

    @Autowired
    JwtService jwtService;

    @PostMapping("/generateToken")
    public ResponseEntity generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        AuthResponce jwt=jwtService.createToken(authRequest);
        return ResponseEntity.ok(jwt);
    }

}
