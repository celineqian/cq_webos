package com.cq.web.service.transport;

import com.cq.web.constant.DriverStatus;
import com.cq.web.constant.VehicleStatus;
import com.cq.web.entity.transport.Driver;
import com.cq.web.entity.transport.Shift;
import com.cq.web.entity.transport.Vehicle;
import com.cq.web.repository.BaseRepository;
import com.cq.web.repository.transport.DriverRepository;
import com.cq.web.repository.transport.ShiftRepository;
import com.cq.web.repository.transport.VehicleRepository;
import com.cq.web.service.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Celine Q
 * @Create 26/10/2018 4:14 PM
 **/
@Service
public class ShiftServiceImpl extends BaseServiceImpl<Shift,Integer> implements ShiftService {

    @Autowired
    private ShiftRepository shiftRepository;

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public BaseRepository<Shift, Integer> getBaseRespository() {
        return shiftRepository;
    }


    @Override
    public void saveOrUpdate(Shift shift) {
        if(shift.getId() != null) {
            Shift s = shiftRepository.findOne(shift.getId());
            if(shift.getDriver().getId() == null)
                s.setDriver(null);
             else
                s.setDriver(shift.getDriver());

            if(shift.getVehicle().getId() == null)
                s.setVehicle(null);
            else
                s.setVehicle(shift.getVehicle());
            s.setRoute(shift.getRoute());
            s.setShiftDate(shift.getShiftDate());
            s.setStatus(shift.getStatus());
            s.setPassengers(shift.getPassengers());
            s.setExpenses(shift.getExpenses());
            update(s);

        }else {
            //新增班次记录
            shift.getVehicle().setStatus(VehicleStatus.USING.getCode());
            shift.getDriver().setStatus(DriverStatus.WORKING.getCode());
            save(shift);
        }
    }
}
