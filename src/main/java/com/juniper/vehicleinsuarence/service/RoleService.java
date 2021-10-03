package com.juniper.vehicleinsuarence.service;

import com.juniper.vehicleinsuarence.domains.Roles;
import com.juniper.vehicleinsuarence.payload.request.RoleDto;
import com.juniper.vehicleinsuarence.repository.RoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    RoleRepository roleRepository;

    ModelMapper modelMapper=new ModelMapper();

    public String saveRole(RoleDto roleDto)
    {
        Roles roles=modelMapper.map(roleDto,Roles.class);
        roleRepository.save(roles);
        return "saqlandi";
    }
}
