package com.cq.web.service.transport;

import com.cq.web.entity.transport.Shift;
import com.cq.web.repository.BaseRepository;
import com.cq.web.repository.transport.ShiftRepository;
import com.cq.web.service.admin.BaseServiceImpl;
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

    @Override
    public BaseRepository<Shift, Integer> getBaseRespository() {
        return shiftRepository;
    }


    @Override
    public void saveOrUpdate(Shift shift) {
        if(shift.getId() != null) {
            Shift s = shiftRepository.findOne(shift.getId());
            s.setDriver(shift.getDriver());
            s.setVehicle(shift.getVehicle());
            s.setRoute(shift.getRoute());
            s.setShiftDate(shift.getShiftDate());
            s.setStatus(shift.getStatus());
            s.setPassengers(shift.getPassengers());
            s.setExpenses(shift.getExpenses());
            update(s);
        }else
            save(shift);
    }
}
