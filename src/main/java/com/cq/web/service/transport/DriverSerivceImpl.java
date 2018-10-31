package com.cq.web.service.transport;

import com.cq.web.constant.DriverStatus;
import com.cq.web.entity.transport.Driver;
import com.cq.web.entity.transport.Shift;
import com.cq.web.repository.BaseRepository;
import com.cq.web.repository.transport.DriverRepository;
import com.cq.web.repository.transport.ShiftRepository;
import com.cq.web.service.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Author Celine Q
 * @Create 20/10/2018 12:01 PM
 **/
@Service
public class DriverSerivceImpl extends BaseServiceImpl<Driver,Integer> implements DriverService {

    @Autowired
    private DriverRepository driverRepository;

    @Override
    public BaseRepository<Driver, Integer> getBaseRespository() {
        return driverRepository;
    }

    @Override
    public void saveOrUpdate(Driver driver) {
        if(driver.getId() != null){
            Driver d = driverRepository.findOne(driver.getId());
            d.setName(driver.getName());
            d.setPhone(driver.getPhone());
            d.setStatus(driver.getStatus());
            d.setLicenseExpireDate(driver.getLicenseExpireDate());
            d.setLicenseType(driver.getLicenseType());
            d.setPhoto(driver.getPhoto());
            d.setRemark(driver.getRemark());
            update(d);
        }else
            save(driver);

    }

    @Override
    public List<Driver> findAvailableDrives() {
        return driverRepository.findAvailableDrives();
    }

    @Override
    public List<Driver> findAllDirvers(Shift shift) {
        List<Driver> list = driverRepository.findAvailableDrives();
        if(shift.getId() != null){
            list.add(shift.getDriver());
        }
        //去重复值
        List drivers = new ArrayList(new HashSet(list));
        //去空值
        drivers.removeAll(Collections.singleton(null));
        return drivers;
    }

}
