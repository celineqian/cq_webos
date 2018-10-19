package com.cq.web.service.transport;

import com.cq.web.entity.transport.Vehicle;
import com.cq.web.repository.BaseRepository;
import com.cq.web.repository.transport.VehicleRepository;
import com.cq.web.service.admin.BaseServiceImpl;


/**
 * @Author Celine Q
 * @Create 19/10/2018 6:28 PM
 **/
public class VehicleServiceImpl extends BaseServiceImpl<Vehicle,Integer> implements VehicleService {

    private VehicleRepository vehicleRepository;
    @Override
    public BaseRepository<Vehicle, Integer> getBaseRespository() {
        return vehicleRepository;
    }

    @Override
    public void saveOrUpdate(Vehicle vehicle) {
        if(vehicle.getId() != null ) {
            Vehicle v = vehicleRepository.findOne(vehicle.getId());
            v.setInsuranceDate(vehicle.getInsuranceDate());
            v.setMaintainanceDate(vehicle.getMaintainanceDate());
            v.setPhoto(vehicle.getPhoto());
            v.setSeater(vehicle.getSeater());
            v.setType(vehicle.getType());
            v.setPlate(vehicle.getPlate());
            v.setRemark(vehicle.getRemark());
            update(v);
        }else {
            save(vehicle);
        }
    }
}
