package com.cq.web.repository.transport;

import com.cq.web.entity.transport.Vehicle;
import com.cq.web.repository.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Celine Q
 * @Create 19/10/2018 6:27 PM
 **/
@Repository
public interface VehicleRepository extends BaseRepository<Vehicle,Integer> {

    @Query("select v from Vehicle v where v.status = 0")
    List<Vehicle> findAvailableVehicles();
}
