package com.cq.web.service.transport;

import com.cq.web.entity.transport.Shift;
import com.cq.web.service.BaseService;

/**
 * @Author Celine Q
 * @Create 26/10/2018 4:13 PM
 **/
public interface ShiftService extends BaseService<Shift,Integer> {

    void saveOrUpdate(Shift shift);

}
