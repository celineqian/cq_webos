package com.cq.web.service.transport;

import com.cq.web.entity.transport.ServiceRecord;
import com.cq.web.repository.BaseRepository;
import com.cq.web.repository.transport.ServiceRecordRepository;
import com.cq.web.service.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Celine Q
 * @Create 2/11/2018 10:44 AM
 **/
@Service
public class ServiceRecordServiceImpl extends BaseServiceImpl<ServiceRecord,Integer> implements ServiceRecordService {


    @Autowired
    private ServiceRecordRepository serviceRecordRepository;

    @Override
    public BaseRepository<ServiceRecord, Integer> getBaseRespository() {
        return serviceRecordRepository;
    }

    @Override
    public void saveOrUpdate(ServiceRecord serviceRecord) {
        if(serviceRecord.getId() != null){
            ServiceRecord sr = serviceRecordRepository.findOne(serviceRecord.getId());
            if(serviceRecord.getDriver().getId() == null)
                sr.setDriver(null);
            else
                sr.setDriver(serviceRecord.getDriver());
            if(serviceRecord.getVehicle().getId() == null)
                sr.setVehicle(null);
            else
                sr.setVehicle(serviceRecord.getVehicle());
            sr.setDetail(serviceRecord.getDetail());
            sr.setServiceDate(serviceRecord.getServiceDate());
            sr.setExpense(serviceRecord.getExpense());
            sr.setRemark(serviceRecord.getRemark());
            update(sr);
        }else{
            if(serviceRecord.getDriver().getId() == null)
                serviceRecord.setDriver(null);
            if(serviceRecord.getVehicle().getId() == null)
                serviceRecord.setVehicle(null);
            save(serviceRecord);
        }

    }

}
