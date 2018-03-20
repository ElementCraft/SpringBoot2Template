package com.noobug.SpringBoot2Template.repository;

import com.noobug.SpringBoot2Template.domain.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepositoty extends JpaRepository<Admin, Long> {
}
