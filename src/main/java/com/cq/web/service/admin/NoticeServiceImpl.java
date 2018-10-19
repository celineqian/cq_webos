package com.cq.web.service.admin;

import com.cq.web.entity.admin.Notice;
import com.cq.web.repository.BaseRepository;
import com.cq.web.repository.admin.NoticeRepository;
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
    private NoticeRepository noticeRepository;

    @Override
    public void saveOrUpdate(Notice notice) {
        if(notice.getId()!=null){
            Notice n = noticeRepository.findOne(notice.getId());
            n.setContent(notice.getContent());
            n.setTitle(notice.getTitle());
            update(n);
        }else{
            notice.setCreateDate(new Date());
            save(notice);
        }
    }

    @Override
    public BaseRepository<Notice, Integer> getBaseRespository() {
        return this.noticeRepository;
    }
}
