package com.juniper.vehicleinsuarence.configuration;

import com.juniper.vehicleinsuarence.security.JwtRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsUtils;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    @Lazy
    private UserDetailsService userDetailsService;

    @Autowired
    JwtRequestFilter jwtRequestFilter;

    //this is authentication purpose
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(getPasswordEncoder());
//        inMemoryAuthentication()
//                .withUser("Elbek")
//                .password("112233")
//                .roles("Admin")
//                .and()
//                .withUser("Sherbek")
//                .password("1122")
//                .roles("User");
    }


    //this is authorization purpose
    @Override
    protected void configure(HttpSecurity http) throws Exception {


        http
                .csrf()
                .disable()
                .headers()
                .frameOptions()
                .disable()
                .and()
                .authorizeRequests()
                .requestMatchers(CorsUtils:: isPreFlightRequest).permitAll()
                .antMatchers("/roles/**").permitAll()
                .antMatchers("/test/auth/admin/**").hasRole("ADMIN")
                .antMatchers("/test/auth/user/**").hasRole("USER")
                .antMatchers("/v1/userResource/**").permitAll()
                .antMatchers("/test/auth/**").permitAll()
                .antMatchers("/authenticate/generateToken").permitAll()
                .antMatchers("/vehicle/**").hasRole("ADMIN")
                .antMatchers("/insurance/**").permitAll()
                .and()
                .exceptionHandling().
                and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http
                .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    @Bean
    PasswordEncoder getPasswordEncoder()
    {
        return new  BCryptPasswordEncoder();
    }
}
