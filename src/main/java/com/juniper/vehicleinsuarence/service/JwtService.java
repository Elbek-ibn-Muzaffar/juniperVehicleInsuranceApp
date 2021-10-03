package com.juniper.vehicleinsuarence.service;

import com.juniper.vehicleinsuarence.payload.AuthRequest;
import com.juniper.vehicleinsuarence.payload.AuthResponce;
import com.juniper.vehicleinsuarence.security.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class JwtService {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    JwtUtils jwtUtils;

    public AuthResponce createToken(AuthRequest authRequest) throws Exception
    {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getName(),authRequest.getPassword())
            );
        }
        catch (BadCredentialsException e)
        {
            throw new Exception("Password yoki login hato",e);
        }

        final UserDetails userDetails=userDetailsService.loadUserByUsername(authRequest.getName());

        final String jwt=jwtUtils.generateToken(userDetails);

        return new AuthResponce(jwt);
    }

    public static String responseExpiredDate(String status)
    {
        return status;
    }

}
