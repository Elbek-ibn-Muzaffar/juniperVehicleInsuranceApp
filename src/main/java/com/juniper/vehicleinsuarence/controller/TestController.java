package com.juniper.vehicleinsuarence.controller;

import org.apache.catalina.webresources.StandardRoot;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test/auth")
public class TestController {

    @GetMapping("/visitors")
    public String getResponce()
    {
        return "hello World";
    }

    @GetMapping("/admin")
    public String getResponseAdmin()
    {
        return "hello admin";
    }

    @GetMapping("/user")
    public String getResponceUser()
    {
        return "hello user";
    }


}
