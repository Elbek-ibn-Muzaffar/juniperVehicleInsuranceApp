package com.juniper.vehicleinsuarence.controller;

import com.juniper.vehicleinsuarence.domains.Users;
import com.juniper.vehicleinsuarence.payload.request.UserReqDto;
import com.juniper.vehicleinsuarence.payload.responce.UserResDto;
import com.juniper.vehicleinsuarence.security.JwtUtils;
import com.juniper.vehicleinsuarence.security.SecurityUtils;
import com.juniper.vehicleinsuarence.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/userResource")

public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/saveUser")
    public ResponseEntity saveUser(@RequestBody UserReqDto users)
    {
        return ResponseEntity.ok(userService.saveUser(users));
    }

    @PutMapping("/updateUser")
    public ResponseEntity updateUsers(@RequestBody UserReqDto userReqDto)
    {
        return ResponseEntity.ok(userService.updateUser(userReqDto));
    }

    @GetMapping("/getUser/{pasport}")
    public ResponseEntity getOneUsers(@PathVariable String pasport)
    {
        return ResponseEntity.ok(userService.getOneUser(pasport));
    }

    @GetMapping("/getAllUsers")
    public List<UserResDto> getAllUsers()
    {
        return userService.getAllUser();
    }

    @GetMapping("/account")
    public ResponseEntity getAccount()
    {


        String pasport= SecurityUtils.getCurrentUsername().get();

        return ResponseEntity.ok(userService.getOneUser(pasport));
    }

}
