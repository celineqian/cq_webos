package com.cq.web.entity.transport;

import com.cq.web.entity.BaseEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * 司机
 * @Author Celine Q
 * @Create 17/10/2018 5:22 PM
 **/
@Entity
@Table(name = "t_driver")
public class Driver extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    /**
     * 司机名字
     */
    private String name;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 驾照类型
     */
    private String licenseType;

    /**
     * 照片
     */
    private String photo;

    /**
     * 驾照过期时间
     */
    private Date licenseExpireDate;

    /**
     * 备注
     */
    private String remark;

    /**
     * 状态
     */
    private Integer status;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLicenseType() {
        return licenseType;
    }

    public void setLicenseType(String licenseType) {
        this.licenseType = licenseType;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Date getLicenseExpireDate() {
        return licenseExpireDate;
    }

    public void setLicenseExpireDate(Date licenseExpireDate) {
        this.licenseExpireDate = licenseExpireDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }


    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", licenseType='" + licenseType + '\'' +
                ", photo='" + photo + '\'' +
                ", licenseExpireDate=" + licenseExpireDate +
                ", remark='" + remark + '\'' +
                ", status=" + status +
                '}';
    }
}
