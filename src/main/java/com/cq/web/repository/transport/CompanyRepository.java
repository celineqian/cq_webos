package com.cq.web.repository.transport;

import com.cq.web.entity.transport.Company;
import com.cq.web.repository.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Celine Q
 * @Create 27/10/2018 11:42 AM
 **/
@Repository
public interface CompanyRepository extends BaseRepository<Company,Integer> {

    @Query("SELECT c FROM Company c WHERE c.id > 0")
    List<Company> findAllCompanies();
}
