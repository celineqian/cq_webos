package com.cq.web.service.transport;

import com.cq.web.entity.transport.Flight;
import com.cq.web.repository.BaseRepository;
import com.cq.web.repository.transport.FlightRepository;
import com.cq.web.service.admin.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Celine Q
 * @Create 22/10/2018 1:09 PM
 **/
@Service
public class FlightServiceImpl extends BaseServiceImpl<Flight,Integer> implements FlightService {

    @Autowired
    private FlightRepository flightRepository;

    @Override
    public BaseRepository<Flight, Integer> getBaseRespository() {
        return flightRepository;
    }

    @Override
    public void saveOrUpdate(Flight flight) {
        if(flight.getId() != null) {
            Flight f = flightRepository.findOne(flight.getId());
            f.setAirline(flight.getAirline());
            f.setDepCode(flight.getDepCode());
            f.setDesCode(flight.getDepCode());
            f.setDepTime(flight.getDepTime());
            f.setDesTime(flight.getDesTime());
            f.setStatus(flight.getStatus());
            f.setRemark(flight.getRemark());
            update(f);
        }else
            save(flight);
    }
}