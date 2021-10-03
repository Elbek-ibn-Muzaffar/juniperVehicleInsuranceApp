package com.juniper.vehicleinsuarence.repository;

import com.juniper.vehicleinsuarence.domains.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users,Long> {
     Users findByName(String username);

     boolean existsByName(String name);


    Users findByPasport(String email);

    boolean existsByPasport(String email);
}
