package com.cq.web.service.transport;

import com.cq.web.entity.transport.ServiceRecord;
import com.cq.web.service.BaseService;

/**
 * @Author Celine Q
 * @Create 2/11/2018 10:43 AM
 **/
public interface ServiceRecordService extends BaseService<ServiceRecord,Integer> {


    void saveOrUpdate(ServiceRecord serviceRecord);
}
