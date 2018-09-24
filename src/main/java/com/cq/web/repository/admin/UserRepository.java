package com.cq.web.repository.admin;

import com.cq.web.entity.admin.User;
import com.cq.web.repository.BaseRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Celine on 01/07/2017.
 */
@Repository
public interface UserRepository extends BaseRepository<User, Integer> {

    User findByUserName(String username);
}
