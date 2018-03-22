package com.noobug.SpringBoot2Template.repository;

import com.noobug.SpringBoot2Template.domain.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {


}
