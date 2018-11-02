package com.cq.web.entity.transport;

import com.cq.web.entity.BaseEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * 保养记录
 * @Author Celine Q
 * @Create 2/11/2018 10:25 AM
 **/
@Entity
@Table(name = "t_servicerecord")
public class ServiceRecord extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    /**
     * 保养车辆
     */
    @ManyToOne
    private Vehicle vehicle;

    /**
     * 司机
     */
    @ManyToOne
    private Driver driver;

    /**
     * 保养日期
     */
    private Date serviceDate;

    /**
     * 保养明细
     */
    private String detail;

    /**
     * 花费
     */
    private Float expense;

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

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Date getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(Date serviceDate) {
        this.serviceDate = serviceDate;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Float getExpense() {
        return expense;
    }

    public void setExpense(Float expense) {
        this.expense = expense;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "ServiceRecord{" +
                "id=" + id +
                ", vehicle=" + vehicle +
                ", driver=" + driver +
                ", serviceDate=" + serviceDate +
                ", detail='" + detail + '\'' +
                ", expense=" + expense +
                ", remark='" + remark + '\'' +
                '}';
    }
}
