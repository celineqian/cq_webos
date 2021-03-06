package com.cq.web.entity.transport;

import com.cq.web.entity.BaseEntity;
import javax.persistence.*;
import java.util.Set;

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
     * 路线名称
     */
    private String name;

    /**
     * 出发地
     */
    private String dep;

    /**
     * 目的地
     */
    private String des;

    /**
     * 备注
     */
    private String remark;

    /**
     * 关联航班
     */

    @ManyToMany(cascade = {CascadeType.REFRESH} , fetch = FetchType.LAZY)
    @JoinTable(name = "t_route_flight" , joinColumns = {@JoinColumn(name = "route_id")},inverseJoinColumns = {@JoinColumn(name = "flight_id")})
    private Set<Flight> flights;

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

    public String getDep() {
        return dep;
    }

    public void setDep(String dep) {
        this.dep = dep;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Set<Flight> getFlights() {
        return flights;
    }

    public void setFlights(Set<Flight> flights) {
        this.flights = flights;
    }

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dep='" + dep + '\'' +
                ", des='" + des + '\'' +
                ", remark='" + remark + '\'' +
                ", flights=" + flights +
                '}';
    }
}
