package com.cq.web.repository.transport;

import com.cq.web.entity.transport.Passenger;
import com.cq.web.repository.BaseRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author Celine Q
 * @Create 27/10/2018 11:00 AM
 **/
@Repository
public interface PassengerRepository extends BaseRepository<Passenger,Integer> {
}
