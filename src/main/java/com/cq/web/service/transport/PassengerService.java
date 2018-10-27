package com.cq.web.service.transport;

import com.cq.web.entity.transport.Passenger;
import com.cq.web.service.BaseService;

/**
 * @Author Celine Q
 * @Create 27/10/2018 11:00 AM
 **/
public interface PassengerService extends BaseService<Passenger,Integer> {

    void saveOrUpdate(Passenger passenger);
}
