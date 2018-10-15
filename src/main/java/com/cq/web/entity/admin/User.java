package com.cq.web.entity.admin;

import com.alibaba.fastjson.annotation.JSONField;
import com.cq.web.entity.BaseEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * <p>
 *     用户
 * </p>
 *
 * Created by Celine on 30/06/2017.
 */
@Entity
@Table(name = "t_user")
public class User extends BaseEntity {


    /**
     * 用户id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    /**
     * 用户名
     */
    private String userName;


    /**
     * 用户昵称
     */
    private String nickName;

    /**
     * 用户密码
     */

    private String password;

    /**
     * 电话
     */
    private String telephone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 逻辑删除状态: 0 未删除; 1 删除
     */
    private Integer deleted;

    /**
     * 是否锁定 0：未锁定; 1: 锁定
     */
    private Integer locked;

    /**
     * 用户描述
     */
    private String description;

    /**
     * 创建时间
     */
    @JSONField(format = "dd-MM-yyyy HH:mm:ss")
    private Date createDate;

    /**
     * 更新时间
     */
    @JSONField(format = "dd-MM-yyy HH:mm:ss")
    private Date updateDate;


    @ManyToMany(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinTable(name = "t_user_role" , joinColumns = {@JoinColumn(name = "user_id")},inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private Set<Role> roles;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public Integer getLocked() {
        return locked;
    }

    public void setLocked(Integer locked) {
        this.locked = locked;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", password='" + password + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", deleted=" + deleted +
                ", locked=" + locked +
                ", description='" + description + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", roles=" + roles +
                '}';
    }
}
