package com.cq.web.repository.admin;

import com.cq.web.entity.admin.LoginLog;
import com.cq.web.repository.BaseRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author Celine Q
 * @Create 3/10/2018 12:07 PM
 **/
@Repository
public interface LoginLogRespository extends BaseRepository<LoginLog,Integer> {
}
