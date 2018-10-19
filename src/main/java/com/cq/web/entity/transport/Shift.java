package com.cq.web.entity.transport;

import com.cq.web.entity.BaseEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * 班次
 * @Author Celine Q
 * @Create 19/10/2018 10:26 AM
 **/
@Entity
@Table(name = "t_shift")
public class Shift extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    /**
     * 班次司机
     */
    @ManyToOne
    private Driver driver;

    /**
     * 班次车辆
     */
    @ManyToOne
    private Vehicle vehicle;

    /**
     * 班次行程
     */
    @ManyToOne
    private Route route;


    /**
     * 班次时间
     */
    private Date shiftDate;

    /**
     * 班次乘客
     */
    @ManyToMany
    @JoinTable(name = "t_shift_passenger" , joinColumns = {@JoinColumn(name = "shift_id")},inverseJoinColumns = {@JoinColumn(name = "passenger_id")})
    private Set<Person> passengers;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Date getShiftDate() {
        return shiftDate;
    }

    public void setShiftDate(Date shiftDate) {
        this.shiftDate = shiftDate;
    }

    public Set<Person> getPassengers() {
        return passengers;
    }

    public void setPassengers(Set<Person> passengers) {
        this.passengers = passengers;
    }

    @Override
    public String toString() {
        return "Shift{" +
                "id=" + id +
                ", driver=" + driver +
                ", vehicle=" + vehicle +
                ", route=" + route +
                ", shiftDate=" + shiftDate +
                ", passengers=" + passengers +
                '}';
    }
}
