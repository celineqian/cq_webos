package com.cq.web.entity.transport;

import com.cq.web.entity.BaseEntity;

import javax.persistence.*;
import java.util.Date;

/** 航班
 * @author: Celine Q
 * @create: 2018-10-21 20:11
 **/
@Entity
@Table(name = "t_flight")
public class Flight extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    /**
     * 航班号
     */
    private String flightNo;

    /**
     * 起飞地
     */
    private String depCode;

    /**
     * 目的地
     */
    private String desCode;

    /**
     * 起飞时间
     */
    private String depTime;

    /**
     * 到达时间
     */
    private String desTime;

    /**
     * 航空公司
     */
    private String airline;

    /**
     * 航班状态
     */
    private Integer status;

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

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public String getDepCode() {
        return depCode;
    }

    public void setDepCode(String depCode) {
        this.depCode = depCode;
    }

    public String getDesCode() {
        return desCode;
    }

    public void setDesCode(String desCode) {
        this.desCode = desCode;
    }

    public String getDepTime() {
        return depTime;
    }

    public void setDepTime(String depTime) {
        this.depTime = depTime;
    }

    public String getDesTime() {
        return desTime;
    }

    public void setDesTime(String desTime) {
        this.desTime = desTime;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", flightNo='" + flightNo + '\'' +
                ", depCode='" + depCode + '\'' +
                ", desCode='" + desCode + '\'' +
                ", depTime='" + depTime + '\'' +
                ", desTime='" + desTime + '\'' +
                ", airline='" + airline + '\'' +
                ", status=" + status +
                ", remark='" + remark + '\'' +
                '}';
    }
}

