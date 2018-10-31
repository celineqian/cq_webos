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
        //更新班次记录
        if(shift.getId() != null) {
            Shift s = shiftRepository.findOne(shift.getId());
            // 更新班次司机为空
            if(shift.getDriver().getId() == null){
                // 数据库本就为空,直接赋值
                if(s.getDriver() == null)
                    s.setDriver(null);
                // 数据库本不为空，设为空，并更新关联司机状态为OK
                else{
                    Driver d = driverRepository.findOne(s.getDriver().getId());
                    d.setStatus(DriverStatus.OK.getCode());
                    driverRepository.saveAndFlush(d);
                    s.setDriver(null);
                }
                //更新班次司机不为空
            } else {
                // 数据库本为空，赋值，修改司机状态为WORKING
                if(s.getDriver() == null){
                    s.setDriver(shift.getDriver());
                    Driver d = driverRepository.findOne(shift.getDriver().getId());
                    d.setStatus(DriverStatus.WORKING.getCode());
                    driverRepository.saveAndFlush(d);
                    // 数据库本不为空，直接赋值，分别修改司机状态
                }else{
                    Driver newDriver = driverRepository.findOne(shift.getDriver().getId());
                    Driver dbDriver = driverRepository.findOne(s.getDriver().getId());
                    s.setDriver(shift.getDriver());
                    dbDriver.setStatus(DriverStatus.OK.getCode());
                    newDriver.setStatus(DriverStatus.WORKING.getCode());
                    driverRepository.saveAndFlush(dbDriver);
                    driverRepository.saveAndFlush(newDriver);
                }
            }
            if(shift.getVehicle().getId() == null){
                if(s.getVehicle() == null)
                    s.setVehicle(null);
                else{
                    Vehicle v = vehicleRepository.findOne(s.getVehicle().getId());
                    v.setStatus(VehicleStatus.OK.getCode());
                    vehicleRepository.saveAndFlush(v);
                    s.setVehicle(null);
                }
            } else{
                if(s.getVehicle() == null){
                    s.setVehicle(shift.getVehicle());
                    Vehicle v = vehicleRepository.findOne(shift.getVehicle().getId());
                    v.setStatus(VehicleStatus.USING.getCode());
                    vehicleRepository.saveAndFlush(v);
                }else{
                    Vehicle newV = vehicleRepository.findOne(shift.getVehicle().getId());
                    Vehicle dbV = vehicleRepository.findOne(s.getVehicle().getId());
                    s.setVehicle(shift.getVehicle());
                    dbV.setStatus(VehicleStatus.OK.getCode());
                    newV.setStatus(VehicleStatus.USING.getCode());
                    vehicleRepository.saveAndFlush(dbV);
                    vehicleRepository.save(newV);
                }
            }
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
