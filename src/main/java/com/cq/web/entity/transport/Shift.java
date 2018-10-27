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
     * 班次状态
     */
    private Integer status;

    /**
     * 班次乘客
     */
    @ManyToMany
    @JoinTable(name = "t_shift_passenger" , joinColumns = {@JoinColumn(name = "shift_id")},inverseJoinColumns = {@JoinColumn(name = "passenger_id")})
    private Set<Passenger> passengers;

    /**
     * 班次成本花费
     */
    @ManyToMany
    @JoinTable(name = "t_shift_expense" , joinColumns = {@JoinColumn(name = "shift_id")},inverseJoinColumns = {@JoinColumn(name = "expense_id")})
    private Set<Expense> expenses;

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Set<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(Set<Passenger> passengers) {
        this.passengers = passengers;
    }

    public Set<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(Set<Expense> expenses) {
        this.expenses = expenses;
    }

    @Override
    public String toString() {
        return "Shift{" +
                "id=" + id +
                ", driver=" + driver +
                ", vehicle=" + vehicle +
                ", route=" + route +
                ", shiftDate=" + shiftDate +
                ", status=" + status +
                ", passengers=" + passengers +
                ", expenses=" + expenses +
                '}';
    }
}
