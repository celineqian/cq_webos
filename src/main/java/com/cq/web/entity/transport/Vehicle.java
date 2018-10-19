package com.cq.web.entity.transport;

import com.cq.web.entity.BaseEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * 车辆
 * @Author Celine Q
 * @Create 17/10/2018 5:37 PM
 **/
@Entity
@Table(name = "t_vehicle")
public class Vehicle extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    /**
     * 型号
     */
    private String type;

    /**
     * 座位数
     */
    private Integer seater;

    /**
     * 车牌号码
     */
    private String plate;

    /**
     * 维护日期
     */
    private Date maintainanceDate;

    /**
     * 保险到期时间
     */
    private Date insuranceDate;
    /**
     * 照片
     */
    private String photo;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getSeater() {
        return seater;
    }

    public void setSeater(Integer seater) {
        this.seater = seater;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public Date getMaintainanceDate() {
        return maintainanceDate;
    }

    public void setMaintainanceDate(Date maintainanceDate) {
        this.maintainanceDate = maintainanceDate;
    }

    public Date getInsuranceDate() {
        return insuranceDate;
    }

    public void setInsuranceDate(Date insuranceDate) {
        this.insuranceDate = insuranceDate;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }


    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", seater=" + seater +
                ", plate='" + plate + '\'' +
                ", maintainanceDate=" + maintainanceDate +
                ", insuranceDate=" + insuranceDate +
                ", photo='" + photo + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
