package com.cq.web.service.transport;

import com.cq.web.entity.transport.Vehicle;
import com.cq.web.repository.BaseRepository;
import com.cq.web.repository.transport.VehicleRepository;
import com.cq.web.service.admin.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @Author Celine Q
 * @Create 19/10/2018 6:28 PM
 **/
@Service
public class VehicleServiceImpl extends BaseServiceImpl<Vehicle,Integer> implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public BaseRepository<Vehicle, Integer> getBaseRespository() {
        return vehicleRepository;
    }

    @Override
    public void saveOrUpdate(Vehicle vehicle) {
        if(vehicle.getId() != null ) {
            Vehicle v = vehicleRepository.findOne(vehicle.getId());
            v.setInsureDate(vehicle.getInsureDate());
            v.setServiceDate(vehicle.getServiceDate());
            v.setPhoto(vehicle.getPhoto());
            v.setSeater(vehicle.getSeater());
            v.setType(vehicle.getType());
            v.setPlate(vehicle.getPlate());
            v.setRemark(vehicle.getRemark());
            v.setStatus(vehicle.getStatus());
            update(v);
        }else {
            save(vehicle);
        }
    }
}
