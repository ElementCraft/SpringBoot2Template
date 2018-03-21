package com.noobug.SpringBoot2Template.domain;

import com.noobug.webtools.entity.BasePojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * 权限组
 *
 * @author noobug.com
 */
@Entity
@Table(name = "authority_group")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorityGroup extends BasePojo{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * 权限模块名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 排序
     */
    @Column(name = "sort_level")
    private Integer sortLevel;
}
