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
 * 权限
 *
 * @author noobug.com
 */
@Entity
@Table(name = "authority")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Authority extends BasePojo {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * 权限名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 权限标识
     */
    @Column(name = "code")
    private String code;

    /**
     * 权限url，用于后端接口权限
     */
    @Column(name = "url")
    private String url;

    /**
     * 权限方法，用于后端接口权限
     */
    @Column(name = "method")
    private String method;

    /**
     * 权限模块id
     */
    @Column(name = "authority_group_id")
    private Long authorityGroupId;

    /**
     * 展示排序
     */
    @Column(name = "sort_level")
    private Integer sortLevel;

    /**
     * 是否删除
     */
    @Column(name = "is_delete")
    private Boolean deleted;

}
