package com.noobug.SpringBoot2Template.repository;

import com.noobug.SpringBoot2Template.domain.AuthorityGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityGroupRepository extends JpaRepository<AuthorityGroup, Long> {


}
