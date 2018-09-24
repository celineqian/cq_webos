package com.cq.web.service.admin;

import com.cq.web.entity.admin.Role;
import com.cq.web.service.BaseService;

/**
 * Created by Celine on 02/07/2017.
 */
public interface RoleService extends BaseService<Role, Integer> {

    /**
     * 添加或者修改角色
     * @param role
     */
    void saveOrUpdate(Role role);

    /**
     * 给角色分配资源
     * @param id 角色ID
     * @param resourceIds 资源ids
     */
    void grant(Integer id, String[] resourceIds);


}
