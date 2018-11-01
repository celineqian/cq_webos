package com.cq.web.entity.admin;

import com.cq.web.entity.BaseEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author Celine Q
 * @Create 3/10/2018 11:20 AM
 **/
@Entity
@Table(name="sys_loginlog")
public class LoginLog extends BaseEntity {

    /**
     * 日志ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    /**
     * 日志名称
     */
    private String logName;

    /**
     * 登陆用户ID
     */
    private Integer userId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 日志信息
     */
    private String message;

    /**
     * 登陆IP地址
     */
    private String ip;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogName() {
        return logName;
    }

    public void setLogName(String logName) {
        this.logName = logName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public String toString() {
        return "LoginLog{" +
                "id=" + id +
                ", logName='" + logName + '\'' +
                ", userId=" + userId +
                ", createTime=" + createTime +
                ", message='" + message + '\'' +
                ", ip='" + ip + '\'' +
                '}';
    }

}
