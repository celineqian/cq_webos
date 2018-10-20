package com.cq.web.service.transport;

import com.cq.web.entity.transport.Driver;
import com.cq.web.repository.BaseRepository;
import com.cq.web.repository.transport.DriverRepository;
import com.cq.web.service.admin.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
