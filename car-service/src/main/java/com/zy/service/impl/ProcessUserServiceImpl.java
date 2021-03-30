package com.zy.service.impl;

import com.zy.entity.User;
import com.zy.mapper.UserMapper;
import com.zy.service.ProcessUserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Ying
 */
public class ProcessUserServiceImpl implements ProcessUserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User queryUser(int UID) {
        User userQ = new User();
        userQ.setUid(UID);
        User user = userMapper.selectOne(userQ);
        return user;
    }

    @Override
    public User queryUser(String nickName) {
        User userQ = new User();
        userQ.setNickName(nickName);
        User user = userMapper.selectOne(userQ);
        return user;
    }

    @Override
    public Boolean insertUser(String nickName,String image){
        User userQ = new User();
        userQ.setNickName(nickName);
        userQ.setImage(image);
        if(!queryUser(nickName).equals(null)){
            System.out.println("not null");
            return true;
        }
        try{
            userMapper.insert(userQ);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
