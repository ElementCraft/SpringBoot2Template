package com.noobug.SpringBoot2Template.repository;

import com.noobug.SpringBoot2Template.domain.User;
import com.noobug.SpringBoot2Template.domain.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {



}
