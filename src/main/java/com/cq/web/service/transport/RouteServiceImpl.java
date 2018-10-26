package com.cq.web.service.transport;

import com.cq.web.entity.transport.Flight;
import com.cq.web.entity.transport.Route;
import com.cq.web.repository.BaseRepository;
import com.cq.web.repository.transport.FlightRepository;
import com.cq.web.repository.transport.RouteRepository;
import com.cq.web.service.admin.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: Celine Q
 * @create: 2018-10-21 17:44
 **/
@Service
public class RouteServiceImpl extends BaseServiceImpl<Route,Integer> implements RouteService {

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private FlightRepository flightRepository;

    @Override
    public BaseRepository<Route, Integer> getBaseRespository() {
        return routeRepository;
    }


    @Override
    public void saveOrUpdate(Route route) {
        if(route.getId() !=null ){
            Route r = routeRepository.findOne(route.getId());
            r.setName(route.getName());
            r.setFlights(route.getFlights());
            r.setDes(route.getDes());
            r.setDep(route.getDep());
            r.setRemark(route.getRemark());
            update(r);
        }else
            save(route);

    }

    @Override
    public void saveOrUpdate(Route route, String[] ids) {
        Set<Flight> flights = new HashSet<Flight>();
        Flight flight;
        if (route.getId() != null) {
            if (ids != null) {
                for (int i = 0; i < ids.length; i++) {
                    Integer fId = Integer.parseInt(ids[i]);
                    flight = flightRepository.findOne(fId);
                    flights.add(flight);
                }
                route.setFlights(flights);
                update(route);
            }
        } else {
            for (int i = 0; i < ids.length; i++) {
                Integer fId = Integer.parseInt(ids[i]);
                flight = flightRepository.findOne(fId);
                flights.add(flight);
            }
            route.setFlights(flights);
            save(route);
        }
    }
}

