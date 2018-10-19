package com.cq.web.entity.transport;

import com.cq.web.entity.BaseEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * 路线
 * @Author Celine Q
 * @Create 17/10/2018 5:42 PM
 **/
@Entity
@Table(name = "t_route")
public class Route extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    /**
     * 出发地
     */
    private String departure;

    /**
     * 目的地
     */
    private String destination;

    /**
     * 航班号
     */
    private String flight;

    /**
     * 出发时间
     */
    private Date departTime;

    /**
     * 到达时间
     */
    private Date destinateTime;

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

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getFlight() {
        return flight;
    }

    public void setFlight(String flight) {
        this.flight = flight;
    }

    public Date getDepartTime() {
        return departTime;
    }

    public void setDepartTime(Date departTime) {
        this.departTime = departTime;
    }

    public Date getDestinateTime() {
        return destinateTime;
    }

    public void setDestinateTime(Date destinateTime) {
        this.destinateTime = destinateTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", departure='" + departure + '\'' +
                ", destination='" + destination + '\'' +
                ", flight='" + flight + '\'' +
                ", departTime=" + departTime +
                ", destinateTime=" + destinateTime +
                ", remark='" + remark + '\'' +
                '}';
    }
}
