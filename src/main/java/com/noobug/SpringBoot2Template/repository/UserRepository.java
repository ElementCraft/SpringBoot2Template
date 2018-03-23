package com.noobug.SpringBoot2Template.repository;

import com.noobug.SpringBoot2Template.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {


    /**
     * find User by account
     *
     * @param s account
     * @return Optional User Entity
     */
    Optional<User> findOneByAccount(String s);
}
