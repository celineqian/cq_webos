package com.cq.web.repository.transport;

import com.cq.web.entity.transport.Driver;
import com.cq.web.entity.transport.Shift;
import com.cq.web.repository.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Celine Q
 * @Create 20/10/2018 12:01 PM
 **/
@Repository
public interface DriverRepository extends BaseRepository<Driver, Integer> {

    @Query("SELECT d FROM Driver d WHERE d.status = 0")
    List<Driver> findAvailableDrives();

}
