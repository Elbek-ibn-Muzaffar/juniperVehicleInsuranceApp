package com.juniper.vehicleinsuarence.service;

import com.juniper.vehicleinsuarence.converters.DtoConverter;
import com.juniper.vehicleinsuarence.domains.Users;
import com.juniper.vehicleinsuarence.payload.request.UserReqDto;
import com.juniper.vehicleinsuarence.payload.responce.UserResDto;
import com.juniper.vehicleinsuarence.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    ModelMapper modelMapper=new ModelMapper();

    DtoConverter dtoConverter=new DtoConverter();

    public String saveUser(UserReqDto users)
    {

        if (!userRepository.existsByPasport(users.getPasport()))
        {
            users.setPassword(passwordEncoder.encode(users.getPassword()));

            userRepository.save(dtoConverter.dtoToEntity(users));
            return "Saqlandi";
        }
        else
            return "Tekshirilsin Saqlanmadi!";
    }

    public String updateUser(UserReqDto userReqDto)
    {
        Users users=userRepository.findByPasport(userReqDto.getPasport());
        users.setName(userReqDto.getName());
        users.setLastName(userReqDto.getLastName());
        users.setPassword(passwordEncoder.encode(userReqDto.getPassword()));
        return "O'zgardi";
    }

    public String deleteUser(String pasport)
    {
        Users users= userRepository.findByPasport(pasport);
        userRepository.delete(users);
        return "O'chirildi";
    }

    public UserResDto getOneUser(String pasport)
    {
        Users users=userRepository.findByPasport(pasport);
        UserResDto userResDto=modelMapper.map(users,UserResDto.class);
        return userResDto;
    }

    public List<UserResDto> getAllUser()
    {
        List<UserResDto> userResDtos=new LinkedList<>();
        List<Users> users=userRepository.findAll();

        for (int i=0;i<users.size();i++)
        {
            userResDtos.add(modelMapper.map(users.get(i),UserResDto.class));
        }

        return userResDtos;

    }


}
