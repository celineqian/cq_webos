package com.cq.web.repository.transport;

import com.cq.web.entity.transport.Flight;
import com.cq.web.repository.BaseRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author Celine Q
 * @Create 22/10/2018 1:12 PM
 **/
@Repository
public interface FlightRepository extends BaseRepository<Flight,Integer> {
}
