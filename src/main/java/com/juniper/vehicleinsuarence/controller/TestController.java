package com.juniper.vehicleinsuarence.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test/auth")
public class TestController {

    @GetMapping("/visitors")
    public String getResponce()
    {
        return "Shunaqa gaplar ekandaaa endi nimayam derdik. Hammaga baxt omad!!!";
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
