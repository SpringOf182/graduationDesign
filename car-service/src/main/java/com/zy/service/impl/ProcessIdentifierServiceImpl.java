package com.zy.service.impl;

import com.zy.entity.User;
import com.zy.mapper.UserMapper;
import com.zy.service.ProcessIdentifierService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Ying
 */
public class ProcessIdentifierServiceImpl implements ProcessIdentifierService {

    @Autowired
    UserMapper userMapper;

    @Override
    public Boolean alterIdentifier(int UID) {
        User userQ = new User();
        userQ.setUid(UID);
        userQ.setIdentifier(1);
        if(userMapper.updateByPrimaryKeySelective(userQ)!= 0){
            return true;
        }
        return false;
    }

    @Override
    public Boolean queryIdentifier(int UID){
        User userQ = new User();
        userQ.setUid(UID);
        User user = userMapper.selectOne(userQ);
        if(user.getIdentifier() == 1){
            System.out.println("yes yes yes yes");
            System.out.println(user.getIdentifier());
            return true;
        }
        System.out.println("false");
        return false;
    }
}
