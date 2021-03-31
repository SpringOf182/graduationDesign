package com.zy.service.impl;

import com.alibaba.fastjson.JSONObject;
import mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zy.service.UserService;
import com.zy.entity.User;


/**
 * User业务服务实现类.
 * @author Ying
 */
@Service("userService")
@Slf4j
public class UserServiceImpl  implements UserService {

    @Autowired
    private ProcessIdentifierServiceImpl processIdentifierService;
    @Autowired
    private UserMapper userMapper;

    @Override
    public User queryUser(String UID) {
        User userQ = new User();
        userQ.setUid(UID);
        User user = userMapper.selectOne(userQ);
        return user;
    }

    @Override
    public User queryUser(User userQ) {
        User user = userMapper.selectOne(userQ);
        return user;
    }

    @Override
    public JSONObject insertUser(String nickName,String image) {
        JSONObject jsonObject = new JSONObject();
        User userQ = new User();
        userQ.setNickName(nickName);
        userQ.setImage(image);
        User user = new User();
        if(!queryUser(userQ).equals(null)){
            System.out.println("not null");
            jsonObject.put("Result", "success");
            jsonObject.put("UID", user.getUid());
            return jsonObject;
        }
        try{
            userMapper.insert(userQ);
            jsonObject.put("Result", "success");
            jsonObject.put("UID", user.getUid());
        }catch (Exception e){
            jsonObject.put("Result", "falied");
        }
        return jsonObject;
    }

    @Override
    public Boolean alterIdentifier(String UID) {
        if(queryUser(UID).equals(null)) {
            return false;
        }
        if(processIdentifierService.queryIdentifier(UID)) {
            return true;
        }
        return processIdentifierService.alterIdentifier(UID);
    }

    @Override
    public Boolean queryIdentifier(String UID){
        if(queryUser(UID).equals(null)) {
            return false;
        }
        return processIdentifierService.queryIdentifier(UID);
    }

}
