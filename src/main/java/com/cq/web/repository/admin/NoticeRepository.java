package com.cq.web.repository.admin;

import com.cq.web.entity.admin.Notice;
import com.cq.web.repository.BaseRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: Celine Q
 * @create: 2018-09-25 20:49
 **/
@Repository
public interface NoticeRepository extends BaseRepository<Notice, Integer> {
}
