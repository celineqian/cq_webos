package com.cq.web.service.admin.impl;

import com.cq.web.common.MD5Utils;
import com.cq.web.entity.admin.Role;
import com.cq.web.entity.admin.User;
import com.cq.web.repository.BaseRepository;
import com.cq.web.repository.admin.RoleRepository;
import com.cq.web.repository.admin.UserRepository;
import com.cq.web.service.admin.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Celine on 02/07/2017.
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User, Integer> implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;



    @Override
    public void saveOrUpdate(User user) {
        if(user.getId() != null){
            User u = userRepository.findOne(user.getId());
            u.setNickName(user.getNickName());
            u.setTelephone(user.getTelephone());
            u.setEmail(user.getEmail());
            u.setDescription(user.getDescription());
            u.setLocked(user.getLocked());
            u.setUpdateDate(new Date());
            update(u);
        }else {
            //创建新用户
            user.setCreateDate(new Date());
            user.setUpdateDate(new Date());
            user.setDeleteStatus(0);
            user.setPassword(MD5Utils.md5(null == user.getPassword() ? "111111" : user.getPassword()));
            save(user);
        }
    }


    @Override
    public BaseRepository<User, Integer> getBaseRespository() {
        return this.userRepository;
    }

    public void delete(Integer id) {
        User user = userRepository.findOne(id);
        Assert.state(!"celine".equals(user.getUserName()),"[WARNING!]Can't delete administrator!");
        super.delete(id);

    }

    @Override
    public void grant(Integer id, String[] roleIds) {
        User user = userRepository.findOne(id);
        Assert.notNull(user,"[WARNING!] User does not exist!");
//        Assert.state(!"celine".equals(user.getUserName()),"[WARNING!] Administrator can not edit role");
        Role role;
        Set<Role> roles = new HashSet<Role>();
        if(roleIds != null) {
            for (int i = 0; i < roleIds.length; i++){
                Integer rId = Integer.parseInt(roleIds[i]);
                role = roleRepository.findOne(rId);
                roles.add(role);
            }
        }
        user.setRoles(roles);
        update(user);

    }


}
