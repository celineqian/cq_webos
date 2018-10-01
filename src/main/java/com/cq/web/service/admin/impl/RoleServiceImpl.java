package com.cq.web.service.admin.impl;

import com.cq.web.entity.admin.Resource;
import com.cq.web.entity.admin.Role;
import com.cq.web.repository.BaseRepository;
import com.cq.web.repository.admin.ResourceRepository;
import com.cq.web.repository.admin.RoleRepository;
import com.cq.web.service.admin.RoleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Celine on 02/07/2017.
 */
@Service
public class RoleServiceImpl extends BaseServiceImpl<Role, Integer> implements RoleService {


    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private ResourceRepository resourceRepository;

    @Override
    public BaseRepository<Role, Integer> getBaseRespository() {
        return this.roleRepository;
    }

    @Override
    public void saveOrUpdate(Role role) {
        if(role.getId() != null ){
            //更新Role信息
            Role r = find(role.getId());
            r.setName(role.getName());
            r.setDescription(role.getDescription());
            r.setStatus(role.getStatus());
            r.setUpdateDate(new Date());
            update(r);
        }else{
            role.setCreateDate(new Date());
            role.setUpdateDate(new Date());
            save(role);
        }

    }

    public void delete(Integer id){
        Role role = find(id);
        Assert.state(!"administrator".equals(role.getRoleKey()),"[WARNING!] Administrator Role can not be deleted!");
        super.delete(role);
    }

    @Override
    public void grant(Integer id, String[] resourceIds) {
        Role role = find(id);
        Assert.notNull(role,"[WARNING!] Role does not exist!");
        //Assert.state(!"administrator".equals(role.getRoleKey()),"超级管理员角色不能进行资源分配");
        Resource resource;
        Set<Resource> resources = new HashSet<Resource>();
        if(resourceIds != null) {
            for (int i = 0; i<resourceIds.length; i++){
                if(StringUtils.isBlank(resourceIds[i]) || "0".equals(resourceIds[i])){
                    continue;
                }
                Integer rId = Integer.parseInt(resourceIds[i]);
                resource = resourceRepository.findOne(rId);
                resources.add(resource);
            }
        }
        role.setResources(resources);
        update(role);
    }
}
