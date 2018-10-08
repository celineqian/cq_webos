package com.cq.web;

import com.cq.web.entity.admin.LoginLog;
import com.cq.web.repository.admin.LoginLogRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @Author Celine Q
 * @Create 3/10/2018 4:21 PM
 **/

@SpringBootTest
@RunWith(SpringRunner.class)
public class LoginLogTests {

    @Autowired
    private LoginLogRepository respository;

    @Test
    public void loginLogSavetest(){
        LoginLog log = new LoginLog();
        log.setId(1);
        log.setLogName("test");
        log.setMessage("test");
        log.setCreateTime(new Date());
        respository.saveAndFlush(log);
    }
}
