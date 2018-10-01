package com.cq.web.service.admin;

import com.cq.web.entity.admin.Notice;
import com.cq.web.service.BaseService;

/**
 * @Author Celine Q
 * @Create 1/10/2018 3:52 PM
 **/
public interface NoticeService extends BaseService<Notice, Integer> {
    /**
     * 增加或者修改通知
     * @param notice
     */
    void saveOrUpdate(Notice notice);
}
