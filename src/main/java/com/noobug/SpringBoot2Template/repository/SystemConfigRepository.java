package com.noobug.SpringBoot2Template.repository;

import com.noobug.SpringBoot2Template.domain.SystemConfig;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SystemConfigRepository extends JpaRepository<SystemConfig, Long> {

    List<SystemConfig> getAllByDeleted(Boolean deleted);

}
