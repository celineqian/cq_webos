package com.cq.web.service.admin.impl;

import com.cq.web.entity.admin.Resource;
import com.cq.web.entity.admin.Role;
import com.cq.web.repository.BaseRepository;
import com.cq.web.repository.admin.ResourceRepository;
import com.cq.web.service.admin.ResourceService;
import com.cq.web.service.admin.RoleService;
import com.cq.web.vo.ZtreeView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by Celine on 02/07/2017.
 */
@Service
public class ResourceServiceImpl extends BaseServiceImpl<Resource, Integer> implements ResourceService {

    @Autowired
    private ResourceRepository resourceRepository;

    @Autowired
    private RoleService roleService;

    @Override
    public BaseRepository<Resource, Integer> getBaseRespository() {
        return this.resourceRepository;
    }

    @Override
    @Cacheable(value = "resourceCache" , key = "'tree' + '#roleId'")
    public List<ZtreeView> tree(int roleId) {
        List<ZtreeView> resulTreeNodes = new ArrayList<ZtreeView>();
        Role role = roleService.find(roleId);
        Set<Resource> roleResources = role.getResources();
        resulTreeNodes.add(new ZtreeView(0L,null,"System Menu",true));
        ZtreeView node;
        Sort sort = new Sort(Sort.Direction.ASC,"parent" ,"id","sort");
        List<Resource> all = resourceRepository.findAll(sort);
        for(Resource resource : all) {
            node = new ZtreeView();
            node.setId(Long.valueOf(resource.getId()));
            if(resource.getParent() == null) {
                node.setpId(0L);
            }else{
                node.setpId(Long.valueOf(resource.getParent().getId()));
            }
            node.setName(resource.getName());
            if(roleResources != null && roleResources.contains(resource)){
                node.setChecked(true);
            }
            resulTreeNodes.add(node);
        }
        return resulTreeNodes;
    }

    @Override
    @CacheEvict(value = "resourceCache")
    public void saveOrUpdate(Resource resource) {
        if(resource.getId() != null){
            Resource r = resourceRepository.findOne(resource.getId());
            r.setName(resource.getName());
            r.setSourceKey(resource.getSourceKey());
            r.setType(resource.getType());
            r.setSourceUrl(resource.getSourceUrl());
            r.setLevel(resource.getLevel());
            r.setSort(resource.getSort());
            r.setIcon(resource.getIcon());
            r.setIsHidden(resource.getIsHidden());
            r.setDescription(resource.getDescription());
            r.setUpdateDate(new Date());
            r.setParent(resource.getParent());
            update(r);
        }else{
            resource.setCreateDate(new Date());
            resource.setUpdateDate(new Date());
            save(resource);
        }

    }



    @CacheEvict(value = "resourceCache")
    public void delete(Integer id){
        resourceRepository.deleteGrant(id);
        super.delete(id);
    }
}
