package com.cq.web.entity.admin;

import com.cq.web.entity.BaseEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author Celine Q
 * @Create 5/10/2018 9:48 AM
 **/
@Entity
@Table(name = "t_operationlog")
public class OperationLog extends BaseEntity {

    /**
     * 操作日志ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    /**
     * 日志类型
     */
    private String logType;

    /**
     * 日志名称
     */
    private String logName;

    /**
     * 用户名称
     */
    private Integer userId;

    /**
     * 类名称
     */
    private String className;

    /**
     * 方法名称
     */
    private String method;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 是否成功
     */
    private String succeed;

    /**
     * 备注
     */
    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType;
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

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getSucceed() {
        return succeed;
    }

    public void setSucceed(String succeed) {
        this.succeed = succeed;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "OperationLog{" +
                "id=" + id +
                ", logType='" + logType + '\'' +
                ", logName='" + logName + '\'' +
                ", userId=" + userId +
                ", className='" + className + '\'' +
                ", method='" + method + '\'' +
                ", createTime=" + createTime +
                ", succeed='" + succeed + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }

}
