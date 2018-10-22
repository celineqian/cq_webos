package com.cq.web.service.transport;

import com.cq.web.entity.transport.Flight;
import com.cq.web.service.BaseService;

/**
 * @Author Celine Q
 * @Create 22/10/2018 1:08 PM
 **/
public interface FlightService extends BaseService<Flight,Integer> {

    /**
     * 增加或者修改航班
     * @param flight
     */
    void saveOrUpdate(Flight flight);
}
