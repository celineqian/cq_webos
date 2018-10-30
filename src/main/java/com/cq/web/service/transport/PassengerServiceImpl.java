package com.cq.web.service.transport;

import com.cq.web.entity.transport.Passenger;
import com.cq.web.repository.BaseRepository;
import com.cq.web.repository.transport.PassengerRepository;
import com.cq.web.service.admin.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Celine Q
 * @Create 27/10/2018 11:01 AM
 **/
@Service
public class PassengerServiceImpl extends BaseServiceImpl<Passenger,Integer> implements PassengerService {

    @Autowired
    private PassengerRepository passengerRepository;

    @Override
    public BaseRepository<Passenger, Integer> getBaseRespository() {
        return passengerRepository;
    }

    @Override
    public void saveOrUpdate(Passenger passenger) {
        if(passenger.getId() != null){
            Passenger p = passengerRepository.findOne(passenger.getId());
            p.setAddress(passenger.getAddress());
            p.setName(passenger.getName());
            p.setPhone(passenger.getPhone());
            if(passenger.getCompany().getId()==null)
                p.setCompany(null);
            else
                p.setCompany(passenger.getCompany());
            update(p);
        }else{
            if(passenger.getCompany().getId()==null)
                passenger.setCompany(null);
            save(passenger);
        }
    }
}
