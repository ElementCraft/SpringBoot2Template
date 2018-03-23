package com.noobug.SpringBoot2Template.repository;

import com.noobug.SpringBoot2Template.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Long> {

    /**
     * get
     * @param id
     * @return
     */
    @Query("select o.name from Role o left join UserRole t on o.id = t.id where o.id=:id ")
    List<String> findAllUserRoles(@Param("id") Long id);
}
