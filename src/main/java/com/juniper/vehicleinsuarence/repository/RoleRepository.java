package com.juniper.vehicleinsuarence.repository;

import com.juniper.vehicleinsuarence.domains.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Roles,Long> {

}
