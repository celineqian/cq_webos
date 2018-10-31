package com.cq.web.service.transport;

import com.cq.web.entity.transport.Driver;
import com.cq.web.entity.transport.Shift;
import com.cq.web.service.BaseService;

import java.util.List;
import java.util.Set;

/**
 * @Author Celine Q
 * @Create 20/10/2018 12:00 PM
 **/
public interface DriverService extends BaseService<Driver,Integer> {

    /**
     * 增加或者修改司机
     * @param driver
     */
    void saveOrUpdate(Driver driver);


    /**
     * 所有空闲司机
     */
    List<Driver> findAvailableDrives();


    List<Driver> findAllDirvers(Shift shift);

}
