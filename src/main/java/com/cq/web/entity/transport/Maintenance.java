package com.cq.web.entity.transport;

import com.cq.web.entity.BaseEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * 车辆保养
 * @Author Celine Q
 * @Create 1/11/2018 4:35 PM
 **/
@Entity
@Table(name = "t_maintenance")
public class Maintenance extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    /**
     * 保养明细
     */
    private String detail;

    /**
     * 保养日期
     */
    private Date serviceDate;

    /**
     * 花费
     */
    @OneToMany
    private Set<Expense> expenses;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Date getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(Date serviceDate) {
        this.serviceDate = serviceDate;
    }

    public Set<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(Set<Expense> expenses) {
        this.expenses = expenses;
    }

    @Override
    public String toString() {
        return "Maintenance{" +
                "id=" + id +
                ", detail='" + detail + '\'' +
                ", serviceDate=" + serviceDate +
                ", expenses=" + expenses +
                '}';
    }
}
