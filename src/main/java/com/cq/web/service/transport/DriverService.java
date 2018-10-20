package com.cq.web.service.transport;

import com.cq.web.entity.transport.Driver;
import com.cq.web.service.BaseService;

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
}
