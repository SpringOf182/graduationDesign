package com.zy.service.impl;

import com.alibaba.fastjson.JSONObject;
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
    private static ProcessUserServiceImpl qu;
    private static ProcessIdentifierServiceImpl pi;

    @Override
    public User queryUser(int arg) {
        return qu.queryUser(arg);
    }

    @Override
    public User queryUser(String arg) {
        return qu.queryUser(arg);
    }

    @Override
    public JSONObject insertUser(String nickName,String image) {
        JSONObject jsonObject = new JSONObject();
        User user = new User();
        if(qu.insertUser(nickName, image)){
            jsonObject.put("Result", "success");
            user = qu.queryUser(nickName);
            jsonObject.put("UID", user.getUid());
        }else{
            jsonObject.put("Result", "falied");
        }
        return jsonObject;
    }

    public static Boolean alterIdentifier(int UID) {
        if(qu.queryUser(UID).equals(null)) {
            return false;
        }
        if(pi.queryIdentifier(UID)) {
            return true;
        }
        return pi.alterIdentifier(UID);
    }

    public static Boolean queryIdentifier(int UID){
        if(qu.queryUser(UID).equals(null)) {
            return false;
        }
        return pi.queryIdentifier(UID);
    }

}
