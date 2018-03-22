package com.noobug.SpringBoot2Template.repository;

import com.noobug.SpringBoot2Template.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {


}
