package com.cq.web.service.transport;

import com.cq.web.entity.transport.Maintenance;
import com.cq.web.repository.BaseRepository;
import com.cq.web.repository.transport.MaintenanceRepository;
import com.cq.web.service.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author Celine Q
 * @Create 1/11/2018 4:50 PM
 **/
@org.springframework.stereotype.Service
public class MaintenanceServiceImpl extends BaseServiceImpl<Maintenance,Integer> implements MaintenanceService {

    @Autowired
    private MaintenanceRepository serviceRepository;

    @Override
    public BaseRepository<Maintenance, Integer> getBaseRespository() {
        return serviceRepository;
    }
}

