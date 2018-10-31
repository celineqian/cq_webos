package com.cq.web.service.transport;

import com.cq.web.entity.transport.Shift;
import com.cq.web.entity.transport.Vehicle;
import com.cq.web.service.BaseService;

import java.util.List;
import java.util.Set;

/**
 * @Author Celine Q
 * @Create 19/10/2018 6:28 PM
 **/
public interface VehicleService extends BaseService<Vehicle,Integer> {

    /**
     * 增加或者修改车辆
     * @param vehicle
     */
    void saveOrUpdate(Vehicle vehicle);

    /**
     * 查找全部可用车辆
     */
    List<Vehicle> findAvailableVehicles();

    /**
     * 查找全部可用车辆
     */
    List<Vehicle> findAllVehicles(Shift shift);
}
