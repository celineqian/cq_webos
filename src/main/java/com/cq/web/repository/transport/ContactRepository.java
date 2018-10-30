package com.cq.web.repository.transport;

import com.cq.web.entity.transport.Contact;
import com.cq.web.repository.BaseRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: Celine Q
 * @create: 2018-10-30 22:05
 **/
@Repository
public interface ContactRepository extends BaseRepository<Contact,Integer> {
}

