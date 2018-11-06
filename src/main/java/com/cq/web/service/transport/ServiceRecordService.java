package com.cq.web.service.transport;

import com.cq.web.entity.transport.ServiceRecord;
import com.cq.web.service.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

/**
 * @Author Celine Q
 * @Create 2/11/2018 10:43 AM
 **/
public interface ServiceRecordService extends BaseService<ServiceRecord,Integer> {


    void saveOrUpdate(ServiceRecord serviceRecord);

}
