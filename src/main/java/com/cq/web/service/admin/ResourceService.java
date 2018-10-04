package com.cq.web.service.admin;

import com.cq.web.entity.admin.Resource;
import com.cq.web.service.BaseService;
import com.cq.web.vo.ZtreeView;
import java.util.List;

/**
 * Created by Celine on 02/07/2017.
 */
public interface ResourceService extends BaseService<Resource, Integer> {

    /**
     * 获取角色的权限树
     * @param roleId
     * @return
     */
    List<ZtreeView> tree(int roleId);

    /**
     * 修改或者新增资源
     * @param resource
     */
    void saveOrUpdate(Resource resource);

}
