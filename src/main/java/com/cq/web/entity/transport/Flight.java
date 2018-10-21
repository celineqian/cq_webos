package com.cq.web.entity.transport;

import com.cq.web.entity.BaseEntity;

import javax.persistence.*;
import java.util.Date;

/** 航班
 * @author: Celine Q
 * @create: 2018-10-21 20:11
 **/
@Entity
@Table(name = "f_flight")
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
     * 到达地
     */
    private String desCode;

    /**
     * 起飞时间
     */
    private Date depTime;

    /**
     * 到达时间
     */
    private Date desTime;

    /**
     * 航空公司
     */
    private String airline;

    /**
     * 航班状态
     */
    private String status;

    /**
     * 备注
     */
    private String remark;

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", flightNo='" + flightNo + '\'' +
                ", depCode='" + depCode + '\'' +
                ", desCode='" + desCode + '\'' +
                ", depTime=" + depTime +
                ", desTime=" + desTime +
                ", airline='" + airline + '\'' +
                ", status='" + status + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }

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

    public Date getDepTime() {
        return depTime;
    }

    public void setDepTime(Date depTime) {
        this.depTime = depTime;
    }

    public Date getDesTime() {
        return desTime;
    }

    public void setDesTime(Date desTime) {
        this.desTime = desTime;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}

