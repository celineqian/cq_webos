package com.cq.web.service.admin.impl;

import com.cq.web.entity.admin.Notice;
import com.cq.web.repository.BaseRepository;
import com.cq.web.repository.admin.NoticeRespository;
import com.cq.web.service.admin.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Author Celine Q
 * @Create 1/10/2018 3:53 PM
 **/
@Service
public class NoticeServiceImpl extends BaseServiceImpl<Notice,Integer> implements NoticeService {

    @Autowired
    private NoticeRespository noticeRespository;

    @Override
    public void saveOrUpdate(Notice notice) {
        if(notice.getId()!=null){
            Notice n = noticeRespository.findOne(notice.getId());
            notice.setContent(n.getContent());
            notice.setTitle(n.getTitle());
            update(notice);
        }else{
            notice.setCreateDate(new Date());
            save(notice);
        }
    }

    @Override
    public BaseRepository<Notice, Integer> getBaseRespository() {
        return this.noticeRespository;
    }
}
