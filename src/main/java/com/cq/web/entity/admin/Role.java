package com.cq.web.entity.admin;

import com.alibaba.fastjson.annotation.JSONField;
import com.cq.web.entity.BaseEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * <p>
 *     角色
 * </p>
 *
 * Created by Celine on 30/06/2017.
 */
@Entity
@Table(name = "sys_role")
public class Role extends BaseEntity {

    /**
     * 角色id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;


    /**
     * 角色名称
     */
    private String name;

    /**
     * 角色标识
     */
    private String roleKey;

    /**
     * 角色描述,UI显示
     */
    private String description;


    /**
     * 角色状态，0:正常, 1:删除
     */
    private Integer status;


    /**
     * 创建时间
     */
    @JSONField(format = "dd-MM-yyyy HH:mm:ss")
    private Date createDate;

    /**
     * 更新时间
     */
    @JSONField(format = "dd-MM-yyyy HH:mm:ss")
    private Date updateDate;


    @ManyToMany(cascade = {CascadeType.REFRESH} , fetch = FetchType.LAZY)
    @JoinTable(name = "sys_role_resource", joinColumns ={@JoinColumn(name = "role_id")},inverseJoinColumns = {@JoinColumn(name = "resource_id")})
    private Set<Resource> resources;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoleKey() {
        return roleKey;
    }

    public void setRoleKey(String roleKey) {
        this.roleKey = roleKey;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Set<Resource> getResources() {
        return resources;
    }

    public void setResources(Set<Resource> resources) {
        this.resources = resources;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", roleKey='" + roleKey + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", resources=" + resources +
                '}';
    }

}
