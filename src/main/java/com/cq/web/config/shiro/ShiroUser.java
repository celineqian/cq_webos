package com.cq.web.config.shiro;

import java.io.Serializable;
import java.util.List;

/**
 * @Author Celine Q
 * @Create 3/10/2018 3:06 PM
 **/
public class ShiroUser implements Serializable {

    private static final long serialVersionUID = 1L;

    public Integer id;          // 主键ID
    public String account;      // 账号
    public String name;         // 姓名
    public List<Integer> roleList; // 角色集
    public List<String> roleNames; // 角色名称集

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Integer> roleList) {
        this.roleList = roleList;
    }


    public List<String> getRoleNames() {
        return roleNames;
    }

    public void setRoleNames(List<String> roleNames) {
        this.roleNames = roleNames;
    }
}
