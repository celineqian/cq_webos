package com.cq.web.service.admin;

import com.cq.web.entity.admin.User;
import com.cq.web.service.BaseService;

/**
 * Created by Celine on 02/07/2017.
 */
public interface UserService extends BaseService<User, Integer> {



    /**
     * 增加或者修改用户
     * @param user
     */
    void saveOrUpdate(User user);

    /**
     * 给用户分配角色
     * @param id 用户ID
     * @param roleIds 角色Ids
     */
    void grant(Integer id, String[] roleIds);

    /**
     * 删除用户
     * @param id 用户id
     */
    void delete(Integer id);
}
