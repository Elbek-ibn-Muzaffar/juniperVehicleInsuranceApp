package com.juniper.vehicleinsuarence.controller;

import com.juniper.vehicleinsuarence.payload.request.RoleDto;
import com.juniper.vehicleinsuarence.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    RoleService roleService;

    @PostMapping("/saveRole")
    public ResponseEntity saveRoles(@RequestBody RoleDto roleDto)
    {
        return ResponseEntity.ok(roleService.saveRole(roleDto));
    }
}
