package com.cq.web.service.transport;

import com.cq.web.entity.transport.Company;
import com.cq.web.repository.BaseRepository;
import com.cq.web.repository.transport.CompanyRepository;
import com.cq.web.service.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Celine Q
 * @Create 29/10/2018 11:57 AM
 **/
@Service
public class CompanyServiceImpl extends BaseServiceImpl<Company, Integer> implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;


    @Override
    public BaseRepository<Company, Integer> getBaseRespository() {
        return companyRepository;
    }

    @Override
    public void saveOrUpdate(Company company) {
        if(company.getId() != null){
            Company c = companyRepository.findOne(company.getId());
            c.setName(company.getName());
            c.setContact(company.getContact());
            c.setPhone(company.getPhone());
            c.setRemark(company.getRemark());
            c.setAddress(company.getAddress());
            update(c);
        }else
            save(company);
    }

    @Override
    public List findAllCompanies() {
        return companyRepository.findAllCompanies();
    }


}


