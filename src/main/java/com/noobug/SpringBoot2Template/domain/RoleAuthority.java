package com.noobug.SpringBoot2Template.domain;

import com.noobug.webtools.entity.BasePojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * 角色权限关联
 *
 * @author noobug.com
 */
@Entity
@Table(name = "role_authority")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleAuthority extends BasePojo{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * 角色id
     */
    @Column(name = "role_id")
    private Long roleId;

    /**
     * 权限id
     */
    @Column(name = "authority_id")
    private Long authorityId;


}
