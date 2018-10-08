package com.cq.web.repository.admin;

import com.cq.web.entity.admin.OperationLog;
import com.cq.web.repository.BaseRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author Celine Q
 * @Create 5/10/2018 10:04 AM
 **/
@Repository
public interface OperationLogRepository extends BaseRepository<OperationLog,Integer> {
}
