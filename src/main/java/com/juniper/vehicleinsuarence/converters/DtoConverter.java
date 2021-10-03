package com.juniper.vehicleinsuarence.converters;

import com.juniper.vehicleinsuarence.domains.Users;
import com.juniper.vehicleinsuarence.payload.request.UserReqDto;
import org.modelmapper.ModelMapper;

public class DtoConverter {

    ModelMapper modelMapper=new ModelMapper();

    public Users dtoToEntity(UserReqDto userReqDto)
    {
        return modelMapper.map(userReqDto,Users.class);
    }

}
