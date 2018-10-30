package com.cq.web.service.transport;

import com.cq.web.entity.transport.Company;
import com.cq.web.entity.transport.Contact;
import com.cq.web.service.BaseService;

import java.util.List;

/**
 * @Author Celine Q
 * @Create 29/10/2018 11:56 AM
 **/
public interface CompanyService extends BaseService<Company, Integer> {

    void saveOrUpdate(Company company);

    List findAllCompanies();

}
