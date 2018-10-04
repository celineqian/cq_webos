package com.cq.web.repository.admin;

import com.cq.web.entity.admin.Resource;
import com.cq.web.repository.BaseRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


/**
 * Created by Celine on 01/07/2017.
 */
@Repository
public interface ResourceRepository extends BaseRepository<Resource, Integer> {

    @Modifying
    @Query(nativeQuery = true,value = "DELETE FROM t_role_resource WHERE resource_id = :id")
    @Transactional
    void deleteGrant(@Param("id") Integer id);
}
